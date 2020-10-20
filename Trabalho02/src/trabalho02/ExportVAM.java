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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ExportVAM {

    private static int count = 0;
    public String RESULT = "C:\\Users\\gusta\\Documents\\Trabalho 02 (Final)\\export\\exportVAM";
    private List<Tabelas> Tabelas = new ArrayList<>();
    private CampusDAO CDAO = new CampusDAO();
    private List<Campus> Campus = (List) CDAO.listar();
    private TotalComparator TC = new TotalComparator();
    private QtComparator QC = new QtComparator();

    public ExportVAM(List<Object> Itens, List<Object> Ambientes, List<Object> Servidores, int flag) {
        count++;
        if (flag == 0) {
            RESULT = RESULT + "ValoresAmbientes" + count + ".pdf";
        } else {
            RESULT = RESULT + "QuantidadeAmbientes" + count + ".pdf";
        }
        try {
            this.createPdf(RESULT, Itens, Ambientes, Servidores, flag);
        } catch (Exception e) {
        }

    }

    public void createPdf(String filename, List<Object> Itens, List<Object> Ambientes, List<Object> Servidores, int flag)
            throws IOException, DocumentException {
        Font boldFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        double total = 0;
        double subtotal = 0;
        int qt = 0;
        int cont = 0;
        Campus c;
        for (Object s1 : Servidores) {
            Servidor S = (Servidor) s1;
            c = S.getCampus();
            if (S.getId() != 1) {
                total = 0;
                qt = 0;
                PdfPTable table = new PdfPTable(2);
                PdfPCell cell;
                cell = new PdfPCell(new Phrase("Servidor: " + S.toString()));
                cell.setColspan(2);
                table.addCell(cell);
                for (Object a1 : Ambientes) {
                    Ambiente A = (Ambiente) a1;
                    if (A.getServidor().getId() == S.getId()) {
                        qt++;
                        subtotal = 0;
                        for (Object i1 : Itens) {
                            Item I = (Item) i1;
                            if (A.getId() == I.getAmbiente().getId()) {
                                subtotal = subtotal + I.getValor_compra();
                            }
                        }
                        total = total + subtotal;
                        cell = new PdfPCell(new Phrase("Ambiente: " + A.toString()));
                        cell.setColspan(1);
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase("Valor: " + "R$" + String.format("%.2f", subtotal)));
                        cell.setColspan(1);
                        table.addCell(cell);
                    }

                }
                cell = new PdfPCell(new Phrase("Quantidade de Ambientes: " + qt));
                cell.setColspan(1);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Total: " + "R$" + String.format("%.2f", total)));
                cell.setColspan(1);
                table.addCell(cell);
                if (cont > 0) {
                    table.setSpacingBefore(5);
                    table.setSpacingAfter(5);
                } else {
                    table.setSpacingAfter(5);
                }

                Tabelas.add(new Tabelas(c, table, qt, total));
                cont++;

            }

        }
        if (flag == 0) {
            Tabelas.sort(TC);
        } else {
            Tabelas.sort(QC);
        }

        for (Campus C : Campus) {
            PdfPTable table = new PdfPTable(1);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Campus: " + C.toString(), boldFont));
            cell.setColspan(1);
            table.addCell(cell);
            table.setSpacingBefore(5);
            table.setSpacingAfter(5);
            document.add(table);
            for (Tabelas t : Tabelas) {
                if (t.getCampus().getId() == C.getId()) {
                    document.add(t.getTabela());
                }
            }
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
