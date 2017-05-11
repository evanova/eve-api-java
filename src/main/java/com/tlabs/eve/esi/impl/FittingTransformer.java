package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIFitting;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.devfleet.esi.model.CharacterscharacterIdfittingsItems;
import org.devfleet.esi.model.CharacterscharacterIdfittingsItems1;
import org.devfleet.esi.model.GetCharactersCharacterIdFittings200Ok;
import org.devfleet.esi.model.PostCharactersCharacterIdFittingsFitting;

import java.util.ArrayList;
import java.util.List;

final class FittingTransformer {
    private FittingTransformer() {}

    public static ESIFitting transform(GetCharactersCharacterIdFittings200Ok object) {
        final ESIFitting fitting = new ESIFitting();
        fitting.setName(object.getName());
        fitting.setDescription(object.getDescription());
        fitting.setFittingID(object.getFittingId());
        fitting.setShipTypeID(object.getShipTypeId());

        final List<ESIFitting.Item> items = new ArrayList<>();
        if (CollectionUtils.isEmpty(object.getItems())) {
            return fitting;
        }

        for (CharacterscharacterIdfittingsItems i: object.getItems()) {
            final ESIFitting.Item item = new ESIFitting.Item();
            item.setInvFlag(i.getFlag());
            item.setQuantity(i.getQuantity());
            item.setTypeID(i.getTypeId());
            items.add(item);
        }
        fitting.setItems(items);
        return fitting;
    }

    public static PostCharactersCharacterIdFittingsFitting transform(final ESIFitting fitting) {
        final PostCharactersCharacterIdFittingsFitting object = new PostCharactersCharacterIdFittingsFitting();
        object.setName(fitting.getName());
        object.setDescription(fitting.getDescription());
        if (StringUtils.isBlank(fitting.getDescription())) {
            fitting.setDescription(fitting.getName());
        }
        object.setShipTypeId((int)fitting.getShipTypeID());

        final List<CharacterscharacterIdfittingsItems1> items = new ArrayList<>();
        for (ESIFitting.Item i: fitting.getItems()) {
            final CharacterscharacterIdfittingsItems1 item = new CharacterscharacterIdfittingsItems1();
            item.setFlag(i.getInvFlag());
            item.setTypeId((int)i.getTypeID());
            item.setQuantity((int)i.getQuantity());
            items.add(item);
        }
        object.setItems(items);
        return object;
    }
}
