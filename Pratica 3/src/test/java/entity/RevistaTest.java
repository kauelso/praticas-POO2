package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RevistaTest {

    @Test
    void print() throws Exception {
        Revista revista = new Revista("tittle",1999,"org",1,1);
        Assertions.assertEquals("Revista: tittle 1999 org 1 1", revista.print());
        revista.setAno(2000);
        revista.setNro(3);
        Assertions.assertEquals("Revista: tittle 2000 org 1 3", revista.print());
    }
}