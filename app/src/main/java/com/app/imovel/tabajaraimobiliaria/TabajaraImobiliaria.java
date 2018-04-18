package com.app.imovel.tabajaraimobiliaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.imovel.tabajaraimobiliaria.repositorios.RepositorioImovelArray;
import com.app.imovel.tabajaraimobiliaria.basica.Imovel;

public class TabajaraImobiliaria extends AppCompatActivity {
    // Editores de texto responsaveis por mostrar os dados do imóvel
    private EditText tCodigo;
    private EditText tTipo;
    private EditText tBairro;
    private EditText tArea;
    private EditText tQuartos;
    private EditText tBanheiros;
    private EditText tGaragens;
    private EditText tPreco;

    // Repositorio responsavel por armazenar os dados dos Imóveis
    private RepositorioImovelArray repositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabajara_imobiliaria);
        this.setRepositorio(new RepositorioImovelArray());
        // Cria imóveis falsos
        this.criaImoveisFalsos();
        // Atribui os editores de texto a seus respectivos componentes do design
        tCodigo = (EditText) findViewById(R.id.codigoTexto);
        tTipo = (EditText) findViewById(R.id.tipoTexto);
        tBairro = (EditText) findViewById(R.id.bairroTexto);
        tArea = (EditText) findViewById(R.id.areaTexto);
        tQuartos = (EditText) findViewById(R.id.quartosTexto);
        tBanheiros = (EditText) findViewById(R.id.banheirosTexto);
        tGaragens = (EditText) findViewById(R.id.garagensTexto);
        tPreco = (EditText) findViewById(R.id.precoTexto);
        this.atualizaImovelMostrado(this.repositorio.getFirst());
    }

    /**
     * Tratador de eventos dos botões da interface
     * @param v - Uma instancia de um botão
     */
    public void botaoApertado(View v){
        // Testa se a view passada é um botão
        if(v instanceof Button) {
            Button b = (Button) v;
            // Modifica os dados da interface dependendo de qual botão foi apertado
            if(b.getId() == R.id.bPrimeiro) {
                Imovel primeiro = this.getRepositorio().getFirst();
                this.atualizaImovelMostrado(primeiro);
            }else if(b.getId() == R.id.bAnterior) {
                try {
                    Imovel anterior = this.getRepositorio().previewElement();
                    this.atualizaImovelMostrado(anterior);
                }catch(NullPointerException e) {Toast.makeText(getApplicationContext(),"Já está no primeiro imóvel", Toast.LENGTH_LONG).show();}
            }else if(b.getId() == R.id.bProximo) {
                try {
                Imovel proximo = this.getRepositorio().nextElement();
                this.atualizaImovelMostrado(proximo);
                }catch(NullPointerException e) {Toast.makeText(getApplicationContext(),"Não há mais imóveis para olhar",Toast.LENGTH_LONG).show();}
            }else if(b.getId() == R.id.bUltimo) {
                Imovel ultimo = this.getRepositorio().getLast();
                this.atualizaImovelMostrado(ultimo);
            }
        }
    }

    /**
     * Cria imóveis falsos para testes, e adiciona eles ao repositório
     */
    private void criaImoveisFalsos() {
        Imovel i1= new Imovel(0,"Casa","Bultrins",234.32,4,3,1,345500);
        Imovel i2= new Imovel(1,"Casa","Afogados",320,3,4,2,450000);
        Imovel i3= new Imovel(2,"Apartamento","Recife",45,3,2,1,245000);
        Imovel i4= new Imovel(3,"Mansão","Boa Viagem",750,7,7,3,1525000);
        Imovel i5= new Imovel(4,"Casa de Praia","Porto de Galinhas",210,2,2,1,575000);
        Imovel i6= new Imovel(5,"Apartamento","Brasília Teimosa",75,3,3,2,525000);
        Imovel i7= new Imovel(6,"Apartamento","Graças",34,2,1,1,235000);
        Imovel i8= new Imovel(7,"Casa","Torre",450,4,3,2,750000);
        Imovel i9= new Imovel(8,"Duplex","Graças",135,4,3,1,890000);
        Imovel i10= new Imovel(9,"Casa","Casa Caiada",320,3,3,2,575000);
        Imovel i20= new Imovel(10,"Casa","Fundão",180,1,2,1,130000);
        Imovel i11= new Imovel(11,"Apartamento","Casa Caiada",70,3,3,1,300000);
        Imovel i12= new Imovel(12,"Casa","Casa Caiada",420,3,4,1,620000);
        Imovel i13= new Imovel(13,"Apartamento","Arruda",90,4,2,1,285500.4);
        Imovel i14= new Imovel(14,"Casa de Praia","Boa Viagem",520,4,3,3,1200000);
        Imovel i15= new Imovel(15,"Mansão","Espinheiro",820,6,7,4,1600000);
        Imovel i16= new Imovel(16,"Duplex","Brasília Teimosa",320,5,3,2,923000);
        Imovel i17= new Imovel(17,"Apartamento","Bairro Novo",45,1,1,1,110000);
        Imovel i18= new Imovel(18,"Apartamento","Bultrins",82,3,2,2,422890);
        Imovel i19= new Imovel(19,"Casa","Espinheiro",515,4,3,1,456300.55);
        Imovel i21= new Imovel(20,"Mansão","Espinheiro",1220,7,9,2,600000);
        Imovel i22= new Imovel(21,"Casa","Salgadinho",450,3,4,1,599900.90);
        repositorio.inserir(i1);
        repositorio.inserir(i2);
        repositorio.inserir(i3);
        repositorio.inserir(i4);
        repositorio.inserir(i5);
        repositorio.inserir(i6);
        repositorio.inserir(i7);
        repositorio.inserir(i8);
        repositorio.inserir(i9);
        repositorio.inserir(i10);
        repositorio.inserir(i20);
        repositorio.inserir(i11);
        repositorio.inserir(i12);
        repositorio.inserir(i13);
        repositorio.inserir(i14);
        repositorio.inserir(i15);
        repositorio.inserir(i16);
        repositorio.inserir(i17);
        repositorio.inserir(i18);
        repositorio.inserir(i19);
        repositorio.inserir(i21);
        repositorio.inserir(i22);
    }

    /**
     * Atualiza dados da tela com novos dados de uma outra instancia de um Imóvel
     * @param i
     */
    private void atualizaImovelMostrado(Imovel i) {
        tCodigo.setText(String.valueOf(i.getCodigo()));
        tTipo.setText(i.getTipoImovel());
        tBairro.setText(i.getBairro());
        tArea.setText(String.format("%.2f",i.getArea()));
        tQuartos.setText(i.getNumQuartos()+" "+ (i.getNumQuartos() > 1 ? "Qts" : "Qt"));
        tBanheiros.setText(i.getNumBanheiros()+" "+ (i.getNumBanheiros() > 1 ? "WCs" : "WC"));
        tGaragens.setText(i.getNumGaragens() +" "+ (i.getNumGaragens() > 1 ? "Garagens" : "Garagem"));
        tPreco.setText(String.format("%,.2f",i.getPreco()));
    }

    /**
     * Captura a instancia do repositorio
     * @return Uma instancia do repositorio
     */
    public RepositorioImovelArray getRepositorio() {
        return this.repositorio;
    }

    /**
     * Seta uma nova instancia ao repositorio
     * @param repositorio Uma instancia do repositorio
     */
    private void setRepositorio(RepositorioImovelArray repositorio) {
        this.repositorio = repositorio;
    }
}
