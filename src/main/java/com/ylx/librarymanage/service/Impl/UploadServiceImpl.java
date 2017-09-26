package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.common.utils.excelutil.DataTemplate;
import com.ylx.librarymanage.common.utils.excelutil.ImportExcel;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.model.BookAddition;
import com.ylx.librarymanage.model.MagazineAddition;
import com.ylx.librarymanage.response.ErrorCode;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    private ImportExcel importExcel;
    private BasicMapper basicMapper;
    private BookAdditionMapper bookAdditionMapper;
    private MagazineAdditionMapper magazineAdditionMapper;

    @Override
    public ResponseTemplate uploadExcelFile(MultipartFile multipartFile) {
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            DataTemplate data = importExcel.importExcel(inputStream);
            if (data == null) {
                return ResponseCreator.createErrorResponse(ErrorCode.SYSTEM_ERROR);
            }
            List<List<String>> rows = data.getRows();
            int rowSize = rows.size();
            List<Basic> basics = new ArrayList<>(rowSize);
            List<BookAddition> bookAdditions = new ArrayList<>(rowSize / 2);
            List<MagazineAddition> magazineAdditions = new ArrayList<>(rowSize / 2);
            List<Integer> ids = new ArrayList<>(rowSize);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Basic basic;
            BookAddition bookAddition;
            MagazineAddition magazineAddition;
            for (List<String> row :
                    rows) {
                String type = row.get(Const.FORMATE.TYPE_LOCATION.ordinal());
                if (StringUtils.isEmpty(type)){
                    break;
                }
                boolean book = Const.BOOK_TYPE.equals(type);
                basic = new Basic();
                basic.setType((short) (book ? 0 : 1));
                Integer id = Integer.valueOf(row.get(Const.FORMATE.ID_LOCATION.ordinal()));
                ids.add(id);
                basic.setId(id);
                basic.setName(row.get(Const.FORMATE.NAME_LOCATION.ordinal()));
                basic.setClassicIndex(Short.valueOf(row.get(Const.FORMATE.CLASSIC_LOCATION.ordinal())));
                basic.setInventory(Integer.valueOf(row.get(Const.FORMATE.INVENTORY_LOCATION.ordinal())));
                basic.setBorrowedNumber(Integer.valueOf(row.get(Const.FORMATE.BORROWED_LOCATION.ordinal())));
                basic.setPublicationYear(format.parse(row.get(Const.FORMATE.PUBLICATION_YEAR_LOCATION.ordinal())));
                basic.setPublisher(row.get(Const.FORMATE.PUBLISHER_LOCATION.ordinal()));
                basic.setPrice(Double.valueOf(row.get(Const.FORMATE.PRICE_LOCATIOIN.ordinal())));
                basic.setTrash(false);
                basics.add(basic);
                if (book) {
                    bookAddition = new BookAddition();
                    bookAddition.setId(id);
                    bookAddition.setIsbn(row.get(Const.FORMATE.ISBN_LOCATION.ordinal()));
                    bookAddition.setEditor(row.get(Const.FORMATE.EDITOR_LOCATION.ordinal()));
                    bookAddition.setPageCount(Integer.valueOf(row.get(Const.FORMATE.PAGE_COUNT_LOCATION.ordinal())));
                    bookAddition.setLetterCount(Long.valueOf(row.get(Const.FORMATE.LETTER_COUNT_LOCATION.ordinal())));
                    bookAddition.setLetterPrice(1000 * (basic.getPrice() / bookAddition.getLetterCount()));
                    bookAdditions.add(bookAddition);
                    continue;
                }
                magazineAddition = new MagazineAddition();
                magazineAddition.setId(id);
                magazineAddition.setIssn(row.get(Const.FORMATE.ISSN_LOCATION.ordinal()));
                magazineAddition.setIsdNumber(row.get(Const.FORMATE.ISD_NUMBER_LOCATION.ordinal()));
                magazineAddition.setSubject(row.get(Const.FORMATE.SUBJECT_LOCATION.ordinal()));
                magazineAddition.setImpactFactor(Float.valueOf(row.get(Const.FORMATE.IMPACT_FACTOR_LOCATION.ordinal())));
                magazineAddition.setPublishingCycle(Short.valueOf(row.get(Const.FORMATE.PUBLISHING_CYCLE_LOCATION.ordinal())));
                magazineAddition.setPapers(Short.valueOf(row.get(Const.FORMATE.PAPERS_LOCATION.ordinal())));
                magazineAddition.setAveragePaperPrice(basic.getPrice() / magazineAddition.getPapers());
                magazineAdditions.add(magazineAddition);
            }
            basicMapper.deleteByIds(ids);
            bookAdditionMapper.deleteByIds(ids);
            magazineAdditionMapper.deleteByIds(ids);
            if (!basics.isEmpty()) {
                basicMapper.insertList(basics);
            }
            if (!bookAdditions.isEmpty()) {
                bookAdditionMapper.insertList(bookAdditions);
            }
            if (!magazineAdditions.isEmpty()) {
                magazineAdditionMapper.insertList(magazineAdditions);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return ResponseCreator.createErrorResponse(ErrorCode.SYSTEM_ERROR);
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResponseCreator.createDefaultSuccessResponse();
    }



    @Autowired
    public void setImportExcel(ImportExcel importExcel) {
        this.importExcel = importExcel;
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }

    @Autowired
    public void setMagazineAdditionMapper(MagazineAdditionMapper magazineAdditionMapper) {
        this.magazineAdditionMapper = magazineAdditionMapper;
    }

    @Autowired
    public void setBookAdditionMapper(BookAdditionMapper bookAdditionMapper) {
        this.bookAdditionMapper = bookAdditionMapper;
    }
}
