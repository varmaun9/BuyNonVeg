
/**
*
*/
package com.meat.representation.siren;

import com.meat.fileupload.FileUploadImage;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("fileUploadImageToFileUploadImageRepresentationConverter")
public class FileUploadImageToFileUploadImageRepresentationConverter
        extends PropertyCopyingConverter<FileUploadImage, FileUploadImageRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public FileUploadImageRepresentation convert(final FileUploadImage source) {

        FileUploadImageRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<FileUploadImageRepresentation> factory) {
        super.setFactory(factory);
    }

}
