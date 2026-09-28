package io.github.miguelcaldas0103.documentprocessor.extraction;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

@Service
public class ExtractionService {
    public List<byte[]> renderPages(InputStream bytesStream) throws IOException {
        List<byte[]> pages = new ArrayList<>();
        try (PDDocument document = Loader.loadPDF(bytesStream.readAllBytes())) {
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 300);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                pages.add(baos.toByteArray());
            }
        }
        return pages;
    }
}
