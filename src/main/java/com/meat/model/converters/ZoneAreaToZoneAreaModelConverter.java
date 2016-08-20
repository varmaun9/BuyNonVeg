/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.ZoneArea;
import com.meat.model.ZoneAreaModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaToZoneAreaModelConverter")
public class ZoneAreaToZoneAreaModelConverter implements Converter<ZoneArea, ZoneAreaModel> {
    private static final Logger LOGGER = Logger.getLogger(ZoneAreaToZoneAreaModelConverter.class);
    @Autowired
    private ObjectFactory<ZoneAreaModel> zoneAreaModelFactory;

    /* @Autowired
    private ConversionService conversionService;
    */
    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ZoneAreaModel convert(final ZoneArea source) {
        ZoneAreaModel zoneAreaModel = zoneAreaModelFactory.getObject();
        BeanUtils.copyProperties(source, zoneAreaModel);
        if (source.getZone() != null) {
            zoneAreaModel.setZoneId(source.getZone().getId());
            zoneAreaModel.setZoneName(source.getZone().getZoneName());
        }
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                zoneAreaModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return zoneAreaModel;
    }

    @Autowired
    public void setZoneAreaFactory(final ObjectFactory<ZoneAreaModel> zoneAreaModelFactory) {
        this.zoneAreaModelFactory = zoneAreaModelFactory;
    }
}
