
import java.util.ArrayList;

class Fone{
    public String label;
    public String number;
    
    public static boolean validate(String number){
        int quant = 0;
        String validar = "1234567890";
        String val[] = new String[10];
        String num[] = new String[number.length()];
        val = validar.split("");
        num = number.split("");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < val.length; j++) {
                if(num[i].equals(val[j])){
                    quant++;
                }
            }
        }
        if(quant < number.length()){
            System.out.println("Numero invalido");
            return false;
        }else{
            return true;
        }
    }

    public Fone(String label, String number) {
        if(validate(number)){
            this.label = label;
            this.number = number;
        }
    }
    
    public String toString(){
        return label+":"+number;
    }
}

class Contato{
    private String name;
    private ArrayList<Fone> fone;
    
    public void procurarNull(){
        for (int i = 0; i < fone.size(); i++) {
            if(fone.get(i).label == null || fone.get(i).number == null){
                rmFone(i);
            }
        }
    }
    
    public void addFone(String label, String number){
        fone.add(new Fone(label, number));
        procurarNull();
    }
    
    public void rmFone(int index){
        fone.remove(index);
    }

    public Contato(String name) {
        fone = new ArrayList<Fone>();
        this.name = name;
    }
    
    public String toString(){
        return "Nome:"+name+", Fone:"+fone;
    }
    
    public static void main(String[] args) {
        Contato cont = new Contato("");
        cont = new Contato("Ana");
        cont.addFone("oi", "2r67");
        cont.addFone("dad", "2597");
        cont.addFone("ada", "2167");
        cont.addFone("gfg", "2457");
        System.out.println(cont);
    }
}

