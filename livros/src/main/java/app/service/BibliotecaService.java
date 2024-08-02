package app.service;

import app.entity.Biblioteca;
import app.entity.Livros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BibliotecaService {

    public String save (Biblioteca biblioteca){
        return "Cadastrado com Sucesso";
    }

    public String update (Biblioteca biblioteca, long id){
        return "Atualizado com Sucesso";
    }
    public Biblioteca findById (long id){

        List<Biblioteca> listaTemp = this.findAll();

        for(int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i);
            }
        }
        return null;
    }

    public List<Biblioteca> findAll(){

        List<Biblioteca> lista = new ArrayList<>();
        lista.add(new Biblioteca(1,"Saraiva","45999099909"));
        lista.add(new Biblioteca(2,"Centro","45903033030"));
        lista.add(new Biblioteca(3,"Biblio","45975649582"));
        lista.add(new Biblioteca(4,"Cabral","45994637748"));

        return lista;
    }

    public String delete (long id) {

        List<Biblioteca> listaTemp = this.findAll();

        for (int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i).getNome()+" deletada com sucesso";
            }
        }
        return "Biblioteca Nao Encontrado";
    }
}
