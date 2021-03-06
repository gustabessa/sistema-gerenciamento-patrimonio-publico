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
public class ExportTAM {

    private static int count = 0;
    public String RESULT
            = "C:\\Users\\gusta\\Documents\\Trabalho 02 (Final)\\export\\exportTAM";

    public ExportTAM(List<Object> Itens, List<Object> Ambientes) {
        count++;
        RESULT = RESULT + "TodosAmbientes" + count + ".pdf";
        try {
            this.createPdf(RESULT, Itens, Ambientes);
        } catch (Exception e) {
        }

    }

    public void createPdf(String filename, List<Object> Itens, List<Object> Ambientes)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        double total = 0;
        int cont = 0;
        for (Object a1 : Ambientes) {
            Ambiente A = (Ambiente) a1;
            for(Object i1 : Itens) {
                Item i = (Item) i1;
                if(i.getAmbiente().getId() == A.getId() && A.getId() != 102)
                    total = total + i.getValor_compra();
            }
            PdfPTable table = createTable1(Itens, A);
            if(cont > 0) {
                table.setSpacingBefore(5);
                table.setSpacingAfter(5);
            } else {
                table.setSpacingAfter(5);
            }
            document.add(table);
            cont++;
        }
        Font boldFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Valor total dos ambientes (Itens Pagos fora do calculo): " + "R$" + String.format("%.2f", total), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
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
    public static PdfPTable createTable1(List<Object> Itens, Ambiente A) throws DocumentException {
        double total = 0;
        Font boldFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.85f, 1, 1.25f, 1.25f, 1});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Ambiente: " + A.getCampus().getAbreviacao() + ": " + A.toString(), boldFont));
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Responsável: " + A.getServidor().toString(), boldFont));
        cell.setColspan(4);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Modificado: " + A.getData_modificacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boldFont));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Id Item/Cod Patr.", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Descrição", boldFont));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Estado", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Valor", boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        for (Object i1 : Itens) {
            Item i = (Item) i1;
            if (i.getAmbiente().getId() == A.getId()) {
                total = total + i.getValor_compra();
                cell = new PdfPCell(new Phrase(String.valueOf(i.getId() + "/" + i.getCod_partimonio())));
                cell.setColspan(1);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(i.getEspecificacao()));
                cell.setColspan(2);
                table.addCell(cell);
                String estado;
                switch (i.getEstado()) {
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
                cell = new PdfPCell(new Phrase("R$" + String.format("%.2f", i.getValor_compra())));
                cell.setColspan(1);
                table.addCell(cell);
            }

        }
        cell = new PdfPCell(new Phrase("Exportado em: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), boldFont));
        cell.setColspan(4);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Total: " + "R$" + String.format("%.2f", total), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        return table;
    }

}
