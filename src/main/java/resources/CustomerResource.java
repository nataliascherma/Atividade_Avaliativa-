package resources;


import com.fafram.webservice.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.CustomerService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "Customer") // caminho do recurso
public class CustomerResource {

    @Autowired
    private CustomerService service;



    // endpoint
    @GetMapping // indica que o método responde a uma requisição GET HTTP
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = service.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping // indica que o método responde a uma requisição POST HTTP
    /* A requisição envia um json, que deve ser desserializado para um obj User
    usamos a annotation @RequestBody
     */
    public ResponseEntity<Customer> insert(@RequestBody Customer customer) {
        customer = service.insert(customer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(customer); // Retorna status code 201
    }

    @DeleteMapping(value = "/{id}") // indica que o método responde a uma requisição DELETE HTTP
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}") // inidica que o método responde a uma requisição PUT HTTP
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        customer = service.update(id, customer);
        return ResponseEntity.ok().body(customer);
    }
}