import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class VentanaPrincipal {
    private JPanel rootPanel;
    private JTextField inputYear;
    private JButton avanzaButton;
    private JTextField inputCilindro;
    private JButton retrocedeButton;
    private JTextField inputMarca;
    private JButton cargarButton;
    private JButton guardarButton;
    String filepath ="datos.txt";
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();


    public VentanaPrincipal() {
        avanzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i=0; i<4; i++){
                    String marca= inputMarca.getText();
                    String year= inputYear.getText();
                    String cilindro= inputCilindro.getText();

                    vehiculos.add(new Vehiculo(marca, year, cilindro));
                }

            try(FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream))
            {

                for (int i=0; i<vehiculos.size(); i++){
                    if((vehiculos.get(i++).equals(vehiculos.get(i-1)))) break;
                    else {
                        outputStream.writeObject(vehiculos.get(i).getMarca());
                        outputStream.writeObject(vehiculos.get(i).getYear());
                        outputStream.writeObject(vehiculos.get(i).getCilindro());
                    }
                }


            }catch (IOException exception){
                throw new RuntimeException(new Exception(exception));
            }


            inputYear.setText("");
            inputCilindro.setText("");
            inputMarca.setText("");

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
