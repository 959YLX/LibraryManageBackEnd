package com.ylx.librarymanage.service.Impl;

import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.common.utils.excelutil.DataTemplate;
import com.ylx.librarymanage.common.utils.excelutil.ExportExcel;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.model.BookAddition;
import com.ylx.librarymanage.model.MagazineAddition;
import com.ylx.librarymanage.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {

    private ExportExcel exportExcel;
    private BasicMapper basicMapper;
    private BookAdditionMapper bookAdditionMapper;
    private MagazineAdditionMapper magazineAdditionMapper;

    @Override
    public void export(HttpServletResponse response, Boolean trash) {
        OutputStream outputStream = null;
        try {
            setResponseHeader(response);
            outputStream = response.getOutputStream();
            List<Basic> basics = basicMapper.selectAll(trash);
            List<List<String>> rows = null;
            if (basics != null) {
                int rowSize = basics.size();
                int cellsSize = Const.HEADER.length;
                rows = new ArrayList<>(rowSize);
                BookAddition bookAddition;
                MagazineAddition magazineAddition;
                List<String> contain;
                Integer id;
                Boolean book;
                for (Basic basic : basics) {
                    contain = new ArrayList<>(cellsSize);
                    rows.add(contain);
                    id = basic.getId();
                    book = basic.getType() == 0;
                    contain.add(Const.FORMATE.TYPE_LOCATION.ordinal(), book ? Const.BOOK_TYPE : Const.MAGAZINE_TYPE);
                    contain.add(Const.FORMATE.ID_LOCATION.ordinal(), String.valueOf(id));
                    contain.add(Const.FORMATE.NAME_LOCATION.ordinal(), basic.getName());
                    contain.add(Const.FORMATE.CLASSIC_LOCATION.ordinal(), String.valueOf(basic.getClassicIndex()));
                    contain.add(Const.FORMATE.INVENTORY_LOCATION.ordinal(), String.valueOf(basic.getInventory()));
                    contain.add(Const.FORMATE.BORROWED_LOCATION.ordinal(), String.valueOf(basic.getBorrowedNumber()));
                    contain.add(Const.FORMATE.PUBLICATION_YEAR_LOCATION.ordinal(), String.valueOf(basic.getPublicationYear()));
                    contain.add(Const.FORMATE.PUBLISHER_LOCATION.ordinal(), basic.getPublisher());
                    contain.add(Const.FORMATE.PRICE_LOCATIOIN.ordinal(), String.valueOf(basic.getPrice()));
                    if (book) {
                        bookAddition = bookAdditionMapper.selectById(id);
                        contain.add(Const.FORMATE.ISBN_LOCATION.ordinal(), bookAddition.getIsbn());
                        contain.add(Const.FORMATE.EDITOR_LOCATION.ordinal(), bookAddition.getEditor());
                        contain.add(Const.FORMATE.PAGE_COUNT_LOCATION.ordinal(), String.valueOf(bookAddition.getPageCount()));
                        contain.add(Const.FORMATE.LETTER_COUNT_LOCATION.ordinal(), String.valueOf(bookAddition.getLetterCount()));
                        contain.add(Const.FORMATE.LETTER_PRICE_LOCATION.ordinal(), String.valueOf(bookAddition.getLetterPrice()));
                        continue;
                    }
                    magazineAddition = magazineAdditionMapper.selectById(id);
                    contain.add(Const.FORMATE.ISBN_LOCATION.ordinal(), null);
                    contain.add(Const.FORMATE.EDITOR_LOCATION.ordinal(), null);
                    contain.add(Const.FORMATE.PAGE_COUNT_LOCATION.ordinal(), null);
                    contain.add(Const.FORMATE.LETTER_COUNT_LOCATION.ordinal(), null);
                    contain.add(Const.FORMATE.LETTER_PRICE_LOCATION.ordinal(), null);
                    contain.add(Const.FORMATE.ISSN_LOCATION.ordinal(), magazineAddition.getIsdNumber());
                    contain.add(Const.FORMATE.ISD_NUMBER_LOCATION.ordinal(), magazineAddition.getIsdNumber());
                    contain.add(Const.FORMATE.SUBJECT_LOCATION.ordinal(), magazineAddition.getSubject());
                    contain.add(Const.FORMATE.IMPACT_FACTOR_LOCATION.ordinal(), String.valueOf(magazineAddition.getImpactFactor()));
                    contain.add(Const.FORMATE.PUBLISHING_CYCLE_LOCATION.ordinal(), String.valueOf(magazineAddition.getPublishingCycle()));
                    contain.add(Const.FORMATE.PAPERS_LOCATION.ordinal(), String.valueOf(magazineAddition.getPapers()));
                    contain.add(Const.FORMATE.AVERAGE_PRICE_LOCATION.ordinal(), String.valueOf(magazineAddition.getAveragePaperPrice()));
                }
            }
            DataTemplate data = new DataTemplate();
            data.setHeader(Const.HEADER);
            data.setRows(rows);
            exportExcel.export(outputStream, data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setResponseHeader(HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(Const.EXPORT_FILE_NAME, "UTF8"));
    }

    @Autowired
    public void setExportExcel(ExportExcel exportExcel) {
        this.exportExcel = exportExcel;
    }

    @Autowired
    public void setBookAdditionMapper(BookAdditionMapper bookAdditionMapper) {
        this.bookAdditionMapper = bookAdditionMapper;
    }

    @Autowired
    public void setMagazineAdditionMapper(MagazineAdditionMapper magazineAdditionMapper) {
        this.magazineAdditionMapper = magazineAdditionMapper;
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }
}
