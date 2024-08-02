package app.controller;

import app.service.LivrosService;
import app.entity.Livros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livros livros){
        try{
            String mensagem = this.livrosService.save(livros);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Deu Erro!!!"+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Livros livros, @PathVariable long id){
        try {
            String mensagem = this.livrosService.update(livros, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livros> findById(@PathVariable long id){
        try {
            Livros livros = this.livrosService.findById(id);
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livros>> findAll(){
        try {
            List<Livros> lista = this.livrosService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String mensagem = this.livrosService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

}

