package io.namoo.metro.service.container;

import io.namoo.metro.domain.logic.MetroLogic;
import io.namoo.metro.domain.store.MetroStoreLycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetroSpringService extends MetroLogic {
    //
    @Autowired
    public MetroSpringService(MetroStoreLycler metroStoreLycler) {
        //
        super(metroStoreLycler);
    }
}