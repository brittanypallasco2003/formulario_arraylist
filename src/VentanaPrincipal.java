import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class VentanaPrincipal {
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton avanzaButton;
    private JTextField textField2;
    private JButton retrocedeButton;
    private JTextField textField3;
    private JButton cargarButton;
    private JButton guardarButton;
    String filepath ="datos.dat";
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();


    public VentanaPrincipal() {
        avanzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculos.add(new Vehiculo("","",""));
                vehiculos.add(new Vehiculo("","",""));
                vehiculos.add(new Vehiculo("","",""));
                vehiculos.add(new Vehiculo("","",""));


            try(FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream))
            {
                for(Vehiculo vehiculo: vehiculos){

                    String marca=textField1.getText();
                    vehiculo.setMarca(marca);
                    String year=textField2.getText();
                    vehiculo.setYear(year);
                    String cilindro=textField3.getText();
                    vehiculo.setCilindro(cilindro);

                    outputStream.writeObject(vehiculo);
                }

            }catch (IOException exception){
                throw new RuntimeException(new Exception(exception));
            }


            textField1.setText("");
            textField2.setText("");
            textField3.setText("");

            }
        });
        retrocedeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileInputStream fileInputStream=new FileInputStream(filepath);
                ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream))
                {
                   for (Vehiculo vehiculo: vehiculos){
                       System.out.println("Marca: "+vehiculo.getMarca());
                       System.out.println("Año: "+vehiculo.getYear());
                       System.out.println("Cilindro: "+vehiculo.getCilindro());
                   }
                }catch (IOException exception){
                    throw new RuntimeException(exception);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehiculos");
        frame.setSize(500,500);
        frame.setContentPane(new VentanaPrincipal().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
