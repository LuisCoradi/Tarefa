package app.service;

import app.entity.Livros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivrosService {

    public String save (Livros livros){
        return "Cadastrado com Sucesso";
    }

    public String update (Livros livros, long id){
        return "Atualizado com Sucesso";
    }
    public Livros findById (long id){

        List<Livros> listaTemp = this.findAll();

        for(int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i);
            }
        }
        return null;
    }

    public List<Livros> findAll(){

        List<Livros> lista = new ArrayList<>();
        lista.add(new Livros(1,"Livro1",1982,"Fulano"));
        lista.add(new Livros(2,"Livro2",2010,"Ciclano"));
        lista.add(new Livros(3,"Livro3",2001,"Cipriano"));
        lista.add(new Livros(4,"Livro4",1932,"Jucilano"));

        return lista;
    }

    public String delete (long id) {

        List<Livros> listaTemp = this.findAll();

        for (int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i).getTitulo()+" deletado com sucesso";
            }
        }
        return "Livro Nao Encontrado";
    }
}
