package com.ylx.librarymanage.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylx.librarymanage.common.Const;
import com.ylx.librarymanage.dao.BasicMapper;
import com.ylx.librarymanage.dao.BookAdditionMapper;
import com.ylx.librarymanage.dao.MagazineAdditionMapper;
import com.ylx.librarymanage.model.Basic;
import com.ylx.librarymanage.model.BookAddition;
import com.ylx.librarymanage.model.MagazineAddition;
import com.ylx.librarymanage.response.ResponseCreator;
import com.ylx.librarymanage.response.ResponseTemplate;
import com.ylx.librarymanage.response.Results.BookAdditionVO;
import com.ylx.librarymanage.response.Results.GetListResult;
import com.ylx.librarymanage.response.Results.MagazineAdditionVO;
import com.ylx.librarymanage.response.Results.TableVO;
import com.ylx.librarymanage.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListServiceImpl implements ListService {

    private BasicMapper basicMapper;
    private MagazineAdditionMapper magazineAdditionMapper;
    private BookAdditionMapper bookAdditionMapper;

    @Override
    public ResponseTemplate getList(boolean trashModel, int pageNumber) {
        PageHelper.startPage(pageNumber, Const.PAGE_SIZE);
        List<Basic> lists = basicMapper.selectAll(trashModel);
        return buildRequiredList(lists);
    }

    public ResponseTemplate buildRequiredList(List<Basic> lists){
        List<TableVO> tableList = new ArrayList<>(lists.size());
        List<Object> additionList = new ArrayList<>(lists.size());
        Map<Integer, TableVO> tableMap = new HashMap<>();
        List<Integer> bookIds = new ArrayList<>();
        List<Integer> magazineIds = new ArrayList<>();
        for (Basic basic :
                lists) {
            tableMap.put(basic.getId(), getTableVO(basic));
            if (basic.getType() == 0) {
                bookIds.add(basic.getId());
            } else {
                magazineIds.add(basic.getId());
            }
        }
        List<BookAddition> bookAdditions = bookIds.isEmpty() ? null : bookAdditionMapper.selectByIds(bookIds);
        List<MagazineAddition> magazineAdditions = magazineIds.isEmpty() ? null : magazineAdditionMapper.selectByIds(magazineIds);
        if (bookAdditions != null) {
            for (BookAddition bookAddition :
                    bookAdditions) {
                tableList.add(tableMap.get(bookAddition.getId()));
                additionList.add(getBookAdditionVO(bookAddition));
            }
        }
        if (magazineAdditions != null) {
            for (MagazineAddition magazineAddition :
                    magazineAdditions) {
                tableList.add(tableMap.get(magazineAddition.getId()));
                additionList.add(getMagazineAdditionVO(magazineAddition));
            }
        }
        PageInfo<Basic> pageResult = new PageInfo<>(lists);
        GetListResult result = new GetListResult(pageResult.getPages(), pageResult.getPageNum(), tableList, additionList);
        return ResponseCreator.createSuccessResponseByData(result);
    }

    private static TableVO getTableVO(Basic basic){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String time = format.format(basic.getPublicationYear());
        return new TableVO(basic.getId(), basic.getName(), basic.getClassicIndex(), basic.getInventory(), basic.getBorrowedNumber(), time, basic.getPublisher(), basic.getPrice());
    }

    private static BookAdditionVO getBookAdditionVO(BookAddition addition){
        return new BookAdditionVO(addition.getIsbn(), addition.getEditor(), addition.getPageCount(), addition.getLetterCount(), addition.getLetterPrice());
    }

    private MagazineAdditionVO getMagazineAdditionVO(MagazineAddition addition){
        return new MagazineAdditionVO(addition.getIssn(), addition.getIsdNumber(), addition.getSubject(), addition.getImpactFactor(), addition.getPublishingCycle(), addition.getPapers(), addition.getAveragePaperPrice());
    }

    @Autowired
    public void setBasicMapper(BasicMapper basicMapper) {
        this.basicMapper = basicMapper;
    }

    @Autowired
    public void setBookAdditionMapper(BookAdditionMapper bookAdditionMapper) {
        this.bookAdditionMapper = bookAdditionMapper;
    }

    @Autowired
    public void setMagazineAdditionMapper(MagazineAdditionMapper magazineAdditionMapper) {
        this.magazineAdditionMapper = magazineAdditionMapper;
    }
}
