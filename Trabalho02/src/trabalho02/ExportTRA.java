/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ExportTRA {

    private static int count = 0;
    public String RESULT = "C:\\Users\\gusta\\Documents\\Trabalho 02 (Final)\\export\\exportTRA";

    public ExportTRA(List<RevisaoAnual> Revisoes, List<ItensRevisao> ItensRev) {
        count++;
        RESULT = RESULT + "TodasRevisoes" + count + ".pdf";
        try {
            this.createPdf(RESULT, Revisoes, ItensRev);
        } catch (Exception e) {
        }

    }

    public void createPdf(String filename, List<RevisaoAnual> Revisoes, List<ItensRevisao> ItensRev)
            throws IOException, DocumentException {
        Font boldFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        int cont = 0;
        double areceber = 0;
        double pago = 0;
        for (RevisaoAnual RA : Revisoes) {
            pago = 0;
            areceber = 0;
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Revisao: " + RA.getId() + "/ Ano: " + RA.getAno(), boldFont));
            cell.setColspan(2);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Estado: " + RA.getEstado(), boldFont));
            cell.setColspan(1);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(RA.getAmbiente().getCampus().getAbreviacao() + ": " + RA.getAmbiente().toString(), boldFont));
            cell.setColspan(1);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Responsável: " + RA.getServidor().toString(), boldFont));
            cell.setColspan(1);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Modificada: " + RA.getData_modificacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boldFont));
            table.addCell(cell);

            for (ItensRevisao ir : ItensRev) {
                if (ir.getRevisao().getId() == RA.getId()) {
                    if (ir.getVerificacao().equals("NÃO ENCONTRADO")) {
                        areceber = areceber + ir.getItem().getValor_compra();
                    } else if (ir.getVerificacao().equals("NÃO ENCONTRADO PAGO")) {
                        pago = pago + ir.getItem().getValor_compra();
                    }
                }

            }
            cell = new PdfPCell(new Phrase("A Receber: " + "R$" + String.format("%.2f", areceber)));
            cell.setColspan(1);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Pago: " + "R$" + String.format("%.2f", pago)));
            cell.setColspan(1);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(""));
            cell.setColspan(1);
            table.addCell(cell);
            if (cont > 0) {
                table.setSpacingBefore(5);
                table.setSpacingAfter(5);
            } else {
                table.setSpacingAfter(5);
            }

            cont++;

            document.add(table);
        }

        document.close();

        //Abrir o PDF :)
        File file = new File(RESULT);
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }

    }

    /**
     * Creates a table; widths are set with setWidths().
     *
     * @return a PdfPTable
     * @throws DocumentException
     */
}
