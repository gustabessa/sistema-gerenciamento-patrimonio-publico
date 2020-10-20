/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02;

import java.util.Comparator;

/**
 *
 * @author gusta
 */
public class QtComparator implements Comparator<Tabelas> {

    @Override
    public int compare(Tabelas o1, Tabelas o2) {
        if(o1.getQtAmb()< o2.getQtAmb())
            return 1;
        else if(o1.getQtAmb() == o2.getQtAmb())
            return 0;
        else return -1;
    }
}
