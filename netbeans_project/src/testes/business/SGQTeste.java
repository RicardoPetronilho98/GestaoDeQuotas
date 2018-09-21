package testes.business;

import socios.business.SGQ;
import socios.business.Socio;
import socios.business.SocioExisteException;
import socios.business.SocioNaoExisteException;

import java.util.HashMap;

public class SGQTeste {

    public static void main(String[] args) {

        SGQ sgq = new SGQ();

        Socio s = new Socio("Ricardo", 20, 'M', "a81744", new HashMap<>());

        try {
            sgq.addSocio(s);
        } catch (SocioExisteException e) {
            e.printStackTrace();
        }

        System.out.println(sgq);

        try {
            sgq.removeSocio(s.getCod());
        } catch (SocioNaoExisteException e) {
            e.printStackTrace();
        }

        System.out.println(sgq);
    }
}