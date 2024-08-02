package app.controller;

import app.entity.Editora;
import app.entity.Livros;
import app.service.EditoraService;
import app.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Editora")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Editora editora){
        try{
            String mensagem = this.editoraService.save(editora);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Deu Erro!!!"+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Editora editora, @PathVariable long id){
        try {
            String mensagem = this.editoraService.update(editora, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Editora> findById(@PathVariable long id){
        try {
            Editora editora = this.editoraService.findById(id);
            return new ResponseEntity<>(editora, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> findAll(){
        try {
            List<Editora> lista = this.editoraService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String mensagem = this.editoraService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
        }
    }

}
