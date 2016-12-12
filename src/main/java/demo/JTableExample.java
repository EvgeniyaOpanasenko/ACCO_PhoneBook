package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Lisa on 12/12/2016.
 */
public class JTableExample {

    ArrayList<Human> humans;
    JTable jTabPeople;
    MyTableModel tModel;


    JTableExample() {
        humans = new ArrayList<>();
        humans.add(new Human("John", "Smith", "1231231"));
        humans.add(new Human("George", "White", "321321312"));
        humans.add(new Human("Olga", "Bregneva", "7171711"));
        //Создаем новый контейнер JFrame
        JFrame jfrm = new JFrame("JTableExample");
        //Устанавливаем диспетчер компоновки
        jfrm.getContentPane().setLayout(new FlowLayout());
        //Устанавливаем размер окна
        jfrm.setSize(900, 170);
        //Устанавливаем завершение программы при закрытии окна
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        tModel = new MyTableModel(humans);
        jTabPeople = new JTable(tModel);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //Устаналиваем размеры прокручиваемой области
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(350, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        jfrm.getContentPane().add(jscrlp);

        JButton btnPress = new JButton("Click!");
        btnPress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                humans.add(new Human("Vasya", "Pupkin", "12300123"));
                tModel.fireTableDataChanged();
            }
        });
        jfrm.add(btnPress);
        //Отображаем контейнер
        jfrm.setVisible(true);
    }

    //Функция main, запускающаяся при старте приложения
    public static void main(String[] args) {

        //ArrayList<Human> humans = new ArrayList<>();


        //Создаем фрейм в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableExample();
            }
        });
    }
}

