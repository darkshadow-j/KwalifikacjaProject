/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwalifikacjawojskowa.raporty;

import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/**
 *
 * @author Paweł
 */
public class Tabela extends XWPFTable {

    public Tabela(CTTbl table, IBody part) {
        super(table, part);
    }
    public Tabela(CTTbl table, IBody part, int row, int col) {
        super(table, part, row, col);
    }




    
        public XWPFParagraph getParagraph(Integer Row, Integer Cell){
        return this.getRow(Row).getCell(Cell).getParagraphArray(0);
    }
    
    
}
