package app.service;

import app.entity.Editora;
import app.entity.Livros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditoraService {

    public String save (Editora editora){
        return "Cadastrado com Sucesso";
    }

    public String update (Editora editora, long id){
        return "Atualizado com Sucesso";
    }
    public Editora findById (long id){

        List<Editora> listaTemp = this.findAll();

        for(int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i);
            }
        }
        return null;
    }

    public List<Editora> findAll(){

        List<Editora> lista = new ArrayList<>();
        lista.add(new Editora(1,"Editonsons","Avenida Brasil, 165"));
        lista.add(new Editora(2,"Rasaiva","Avenida JK, 434"));
        lista.add(new Editora(3,"Editora","Rua Palmas, 691"));
        lista.add(new Editora(4,"Ditada","Avenida Rio Branco, 222"));

        return lista;
    }

    public String delete (long id) {

        List<Editora> listaTemp = this.findAll();

        for (int i = 0; i < listaTemp.size(); i++) {
            if(listaTemp.get(i).getId() == id) {
                return listaTemp.get(i).getNome()+" deletado com sucesso";
            }
        }
        return "Livro Nao Encontrado";
    }
}
