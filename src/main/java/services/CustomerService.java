package services;

import com.fafram.webservice.Customer;
import com.fafram.webservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;





    @Service
    public class CustomerService {

        @Autowired
        private CustomerRepository repository; // injeção de dependência
        private Customer customer;

        public List<Customer> findAll() {
            return repository.findAll();
        }

        public Customer findById(Long id) {
            Optional<Customer> obj = repository.findById(id);
            return obj.get();
        }

        public Customer insert(Customer user) {
            return repository.save(user); // o método save retorna o usuário salvo
        }

        public void delete(Long id){
            repository.deleteById(id);
        }

        public Customer update(Long id, Customer customer) {
            Customer entity = repository.getOne(id);
            updateData(entity, customer);
            return repository.save(entity);
        }

        private void updateData(Customer entity, Customer user) {
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            entity.setCpf(customer.getCpf());


        }
    }
