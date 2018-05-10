package io.namoo.metro.service.rest;

import io.namoo.metro.domain.entity.Metro;
import io.namoo.metro.domain.spec.MetroService;
import io.namoo.metro.domain.spec.sdo.MetroCdo;
import io.namoo.metro.service.container.MetroSpringService;
import io.naraplatform.share.domain.NameValueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metro")
public class MetroResource implements MetroService {
    //
    @Autowired
    private MetroSpringService metroSpringService;

    public MetroResource() {
        //
    }

    @PostMapping("/")
    public String registerMetro(@RequestBody MetroCdo metroCdo) {
        //
        return metroSpringService.registerMetro(metroCdo);
    }

    @GetMapping("/{metroId}")
    public Metro findMetro(@PathVariable String metroId) {
        //
        return metroSpringService.findMetro(metroId);
    }

    @PutMapping("/{metroId}")
    public void modifyMetro(@PathVariable String metroId, @RequestBody NameValueList nameValues) {
        //
        metroSpringService.modifyMetro(metroId, nameValues);
    }

    @DeleteMapping("/{metroId}")
    public void removeMetro(@PathVariable String metroId) {
        //
        metroSpringService.removeMetro(metroId);
    }
}