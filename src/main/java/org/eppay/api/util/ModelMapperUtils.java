package org.eppay.api.util;


import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.eppay.api.common.context.AppContextManager;

import java.util.ArrayList;
import java.util.List;

public class ModelMapperUtils {

    public static <T> T map(Object source, Class<T> destinationClass) throws MappingException {
        return getModelMapper().map(source, destinationClass);
    }

    public static <T> List<T> mapList(List<?> listSources, Class<T> destinationClass) {
        List<T> resultList = new ArrayList<>();

        if (!ArrayUtils.isEmpty(listSources)) {
            for (Object source : listSources) {
                resultList.add(map(source, destinationClass));
            }
        }

        return resultList;
    }

    public static ModelMapper getModelMapper() {
        return AppContextManager.getBean(ModelMapper.class);
    }
}
