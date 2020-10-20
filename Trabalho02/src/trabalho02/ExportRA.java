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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ExportRA {

    private static List<ItensRevisao> ItensRevisao;
    private static RevisaoAnual RA;
    private static int count = 0;
    public String RESULT
            = "C:\\Users\\gusta\\Documents\\Trabalho 02 (Final)\\export\\exportRA";

    public ExportRA(List<ItensRevisao> itensrevisao, RevisaoAnual ra) {
        count++;
        this.ItensRevisao = itensrevisao;
        this.RA = ra;
        RESULT = RESULT + count + RA.getAno() + "." + RA.getId() + ".pdf";
        try {
            this.createPdf(RESULT, ItensRevisao, RA);
        } catch (Exception e) {
        }

    }

    public void createPdf(String filename, List<ItensRevisao> ItensRevisao, RevisaoAnual RA)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfPTable table = createTable1(ItensRevisao, RA);
        document.add(table);

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
    public static PdfPTable createTable1(List<ItensRevisao> ItensRevisao, RevisaoAnual RA) throws DocumentException {
        double pago = 0;
        double total = 0;
        Font boldFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 1, 1.25f, 1.25f, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Revisao: " + RA.getId() + "/ Ano: " + RA.getAno(), boldFont));
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(RA.getAmbiente().getCampus().getAbreviacao() + ": " + RA.getAmbiente().toString(), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Responsável: " + RA.getServidor().toString(), boldFont));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Encerrada: " + RA.getData_modificacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boldFont));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Id Item/Cod Patr.", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Descrição", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Verificação", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Estado", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Valor", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        for (Object ir1 : ItensRevisao) {
            ItensRevisao ir = (ItensRevisao) ir1;
            if (ir.getRevisao().getId() == RA.getId()) {
                total = total + ir.getItem().getValor_compra();
                cell = new PdfPCell(new Phrase(String.valueOf(ir.getItem().getId() + "/" + ir.getItem().getCod_partimonio())));
                cell.setColspan(1);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(ir.getItem().getEspecificacao()));
                cell.setColspan(1);
                table.addCell(cell);
                if (ir.getVerificacao().equals("NÃO ENCONTRADO PAGO")) {
                    pago = pago + ir.getItem().getValor_compra();
                }
                cell = new PdfPCell(new Phrase(ir.getVerificacao()));
                cell.setColspan(1);
                table.addCell(cell);
                String estado;
                switch (ir.getEstado()) {
                    case 1:
                        estado = "NOVO";
                        break;
                    case 2:
                        estado = "BOM";
                        break;
                    case 3:
                        estado = "REGULAR";
                        break;
                    case 4:
                        estado = "PRECÁRIO";
                        break;
                    case 5:
                        estado = "OCIOSO";
                        break;
                    case 6:
                        estado = "RECUPERÁVEL";
                        break;
                    case 7:
                        estado = "ANTIECONÔMICO";
                        break;
                    case 8:
                        estado = "IRRECUPERÁVEL";
                        break;
                    default:
                        estado = "NÃO DEFINIDO";
                        break;
                }
                cell = new PdfPCell(new Phrase(estado));
                cell.setColspan(1);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("R$" + String.format("%.2f", ir.getItem().getValor_compra())));
                cell.setColspan(1);
                table.addCell(cell);
            }

        }
        cell = new PdfPCell(new Phrase("Exportado em: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boldFont));
        cell.setColspan(3);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Pago: " + "R$" + String.format("%.2f", pago), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Total: " + "R$" + String.format("%.2f", total), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        return table;
    }

}
