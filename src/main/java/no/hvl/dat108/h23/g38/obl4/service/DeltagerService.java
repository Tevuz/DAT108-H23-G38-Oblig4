package no.hvl.dat108.h23.g38.obl4.service;

import no.hvl.dat108.h23.g38.obl4.model.Deltager;
import no.hvl.dat108.h23.g38.obl4.persistance.DeltagerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeltagerService extends AbstractService<Deltager, String> {

    public DeltagerService(DeltagerRepository repository) {
        super(repository);
    }
}
