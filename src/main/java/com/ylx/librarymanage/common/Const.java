package com.ylx.librarymanage.common;

public class Const {

    public static final int SUCCESS_CODE = 0;
    public static final String BOOK_TYPE = "book";
    public static final String MAGAZINE_TYPE = "magazine";
    public static final String EXPORT_FILE_NAME = "图书信息.xlsx";

    public static final String SPLIT_CHARACTER = ",";

    public static final int PAGE_SIZE = 10;

    public static final String SEARCH_CHARACTER = "%";

    public static final String[] HEADER = {"类型", "编号", "名称", "分类号", "库存数量", "借出数量", "出版时间", "出版单位", "价格",
                                            "ISBN", "作者", "页数", "字数", "每千字价格",
                                            "ISSN", "检索", "学科领域", "影响因子", "出版周期(月)", "每期论文数", "平均单篇论文价格"};

    public enum FORMATE{
        TYPE_LOCATION,
        ID_LOCATION,
        NAME_LOCATION,
        CLASSIC_LOCATION,
        INVENTORY_LOCATION,
        BORROWED_LOCATION,
        PUBLICATION_YEAR_LOCATION,
        PUBLISHER_LOCATION,
        PRICE_LOCATIOIN,
        ISBN_LOCATION,
        EDITOR_LOCATION,
        PAGE_COUNT_LOCATION,
        LETTER_COUNT_LOCATION,
        LETTER_PRICE_LOCATION,
        ISSN_LOCATION,
        ISD_NUMBER_LOCATION,
        SUBJECT_LOCATION,
        IMPACT_FACTOR_LOCATION,
        PUBLISHING_CYCLE_LOCATION,
        PAPERS_LOCATION,
        AVERAGE_PRICE_LOCATION
    }

}
//[type, id, name, classic, inventory, borrow, publicationYear, publisher, price, ISBN, editor,
// pageCount, letterCount, letterPrice, ISSN, ISD, subject, impact, publishingCycle, papers, average]
