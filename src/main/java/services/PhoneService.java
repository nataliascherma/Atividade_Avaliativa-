package services;

import com.fafram.webservice.Phone;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PhoneService {
    @Autowired
    private PhoneRepository repository;

    public List<Phone> findAll() {
        return repository.findAll();
    }

    public Phone findById(Long id) {
        Optional<Phone> obj = repository.findById(id);
        return obj.get();
    }
    public Phone insert(Phone phone){

        return repository.save(phone); //o método save retorna o usuário salvo
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Phone update(Long id, Phone phone){
        Phone entity = repository.getOne(id);
        updateData(entity,phone);
        return repository.save(entity);
    }

    public void updateData(Phone entity, Phone phone){
        entity.setType(phone.getType());
        entity.setNumber(phone.getNumber());
    }
}

