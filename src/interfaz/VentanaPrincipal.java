/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.modelo.Persona;
import dominio.modelo.Animal;
import dominio.modelo.Veterinaria;
import dominio.modelo.Actividad;
import dominio.modelo.actividades.VisitaVeterinaria;
import dominio.modelo.actividades.OtraActividad;
import dominio.modelo.actividades.Paseo;
import dominio.modelo.actividades.Alimentacion;
import dominio.*;
import dominio.modelo.usuarios.Responsable;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author marce
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Sistema sistema;
    private boolean agregarPerroSeleccionado;
    private boolean agregarUsuarioSeleccionado;
    private String rutaImagenAgregar;
    private Fecha fechaSeleccionada;
    private String rutaImagenRuta;

    private String RUTA_IMAGEN_PERRO_POR_DEFECTO = "images/perroPorDefecto.png";

    public VentanaPrincipal(Sistema sis) {
        sistema = sis;
        fechaSeleccionada = new Fecha();
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            PerroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource(RUTA_IMAGEN_PERRO_POR_DEFECTO)).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        PerroBtnEditar.setVisible(false);
        PerroBtnGuardar.setVisible(false);
        CalPanHoraPersonalizada.setVisible(false);
        CalPanVeterinaria.setVisible(false);
        CalComboVeterinaria.setVisible(false);
        CalBtnVerRuta.setVisible(false);
        CalBtnGroupVeterinaria.clearSelection();
        CalBtnVeterinariaNo.setSelected(true);
        CalBtnGroupRepetir.clearSelection();
        CalBtnGroupRealizada.clearSelection();
        CalBtnRealizadaNo.setSelected(true);
        CalTxtTipoAlimento.setVisible(false);
        CalLblTipoAlimento.setVisible(false);
        CalPanVeterinaria.setVisible(false);
        CalBtnEditar.setVisible(false);
        CalLblHorarios.setVisible(false);
        rutaImagenAgregar = "";
        rutaImagenRuta = "";
        agregarPerroSeleccionado = true;
        agregarUsuarioSeleccionado = true;
        CalPanRuta.setVisible(false);
        this.setSize(950, 625);
    }

    public void resetearPestanaPerros() {
        setearListaPerros();
        if (PerroComboPerros.getItemCount() != 0) {
            Animal perroSeleccionado = sistema.getAnimal(PerroComboPerros.getSelectedItem().toString());
            PerroLblNombre.setText(perroSeleccionado.getNombre().toUpperCase());
            PerroLblPeso.setText("Pesa:       " + perroSeleccionado.getPeso());
            PerroLblAltura.setText("Mide:       " + perroSeleccionado.getAltura());
            PerroLblComentarios.setText("" + perroSeleccionado.getComentarios());
            PerroLblFoto.setIcon(perroSeleccionado.getFoto());
            PerroBtnEditar.setVisible(true);
        } else {
            PerroLblNombre.setText("Nombre:");
            PerroLblPeso.setText("Peso:");
            PerroLblAltura.setText("Altura:");
            PerroLblComentarios.setText("Comentarios:");
            PerroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
            PerroBtnEditar.setVisible(false);
        }
        ocultarAgregarPerro();
        rutaImagenAgregar = "";
    }

    public void inicializarPestanaUsuarios() {

        resetearListaUsuarios();
        if (UsuarioComboUsuarios.getItemCount() != 0) {
            Persona usuarioSeleccionado = sistema.getResponsable(UsuarioComboUsuarios.getSelectedItem().toString());
            UsuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            UsuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
        } else {
            UsuarioLblNombre.setText("Nombre: ");
            UsuarioLblMail.setText("Mail: ");
        }
        ocultarAgregarUsuario();
        agregarUsuarioSeleccionado = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CalBtnGroupRepetir = new javax.swing.ButtonGroup();
        CalBtnGroupVeterinaria = new javax.swing.ButtonGroup();
        CalBtnGroupRealizada = new javax.swing.ButtonGroup();
        Panel = new javax.swing.JTabbedPane();
        panCalendario = new javax.swing.JPanel();
        CalDayChooser = new com.toedter.calendar.JDayChooser();
        CalMonthChooser = new com.toedter.calendar.JMonthChooser();
        CalYearChooser = new com.toedter.calendar.JYearChooser();
        CalScrollActividades = new javax.swing.JScrollPane();
        CalLstActividades = new javax.swing.JList<>();
        CalBtnAgregar = new javax.swing.JButton();
        CalLblTipo = new javax.swing.JLabel();
        CalLblUsuario = new javax.swing.JLabel();
        CalLblPerro = new javax.swing.JLabel();
        CalLblFecha = new javax.swing.JLabel();
        CalComboTipo = new javax.swing.JComboBox<>();
        CalComboUsuario = new javax.swing.JComboBox<>();
        CalComboPerro = new javax.swing.JComboBox<>();
        CalComboHora = new javax.swing.JComboBox<>();
        CalLblHora = new javax.swing.JLabel();
        CalPanHoraPersonalizada = new javax.swing.JPanel();
        CalPanLblMinutos = new javax.swing.JLabel();
        CalPanSpinMinutos = new javax.swing.JSpinner();
        CalPanSpinHora = new javax.swing.JSpinner();
        CalPanLblHora = new javax.swing.JLabel();
        CalLblFechaResp = new javax.swing.JLabel();
        CalLblTituloFecha = new javax.swing.JLabel();
        CalLblTituloActividad = new javax.swing.JLabel();
        CalLblNombre = new javax.swing.JLabel();
        CalTxtNombreResp = new javax.swing.JTextField();
        CalPanVeterinaria = new javax.swing.JPanel();
        CalLblVeterinaria = new javax.swing.JLabel();
        CalBtnVeterinariaSi = new javax.swing.JRadioButton();
        CalBtnVeterinariaNo = new javax.swing.JRadioButton();
        CalComboVeterinaria = new javax.swing.JComboBox<>();
        CalLblMotivo = new javax.swing.JLabel();
        CalComboMotivo = new javax.swing.JComboBox<>();
        CalLblHorarios = new javax.swing.JLabel();
        CalTxtTipoAlimento = new javax.swing.JTextField();
        CalLblTipoAlimento = new javax.swing.JLabel();
        CalLblActividadesDelDia = new javax.swing.JLabel();
        CalScrollInfoAct = new javax.swing.JScrollPane();
        CalTxtAreaInfoAct = new javax.swing.JTextArea();
        CalLblInfoActividad = new javax.swing.JLabel();
        CalBtnEditar = new javax.swing.JButton();
        CalLblRealizada = new javax.swing.JLabel();
        CalBtnRealizadaSi = new javax.swing.JRadioButton();
        CalBtnRealizadaNo = new javax.swing.JRadioButton();
        CalPanRuta = new javax.swing.JPanel();
        CalSpinDistancia = new javax.swing.JSpinner();
        CalLblKilometros = new javax.swing.JLabel();
        CalBtnRuta = new javax.swing.JButton();
        CalLblRuta = new javax.swing.JLabel();
        CalLblDistancia = new javax.swing.JLabel();
        CalBtnAgregarDatos = new javax.swing.JButton();
        CalLblAdvertencia = new javax.swing.JLabel();
        CalBtnVerRuta = new javax.swing.JButton();
        panUsuarios = new javax.swing.JPanel();
        UsuarioLblUsuarios = new javax.swing.JLabel();
        UsuarioComboUsuarios = new javax.swing.JComboBox<>();
        UsuarioLblNombre = new javax.swing.JLabel();
        UsuarioLblMail = new javax.swing.JLabel();
        UsuarioTxtNombre = new javax.swing.JTextField();
        UsuarioTxtMail = new javax.swing.JTextField();
        UsuarioBtnAgregar = new javax.swing.JButton();
        UsuarioLblActividades = new javax.swing.JLabel();
        UsuarioScrollActividades = new javax.swing.JScrollPane();
        UsuarioLstActividades = new javax.swing.JList<>();
        UsuarioLblActividad = new javax.swing.JLabel();
        UsuarioLblFecha = new javax.swing.JLabel();
        UsuarioScrollFechas = new javax.swing.JScrollPane();
        UsuarioLstFechas = new javax.swing.JList<>();
        UsuarioLblAdvertencia = new javax.swing.JLabel();
        panPerros = new javax.swing.JPanel();
        PerroBtnAgregar = new javax.swing.JButton();
        PerroLblPerros = new javax.swing.JLabel();
        PerroPanInformacion = new javax.swing.JPanel();
        PerroPanFoto = new javax.swing.JPanel();
        PerroLblFoto = new javax.swing.JLabel();
        PerroLblAltura = new javax.swing.JLabel();
        PerroLblComentarios = new javax.swing.JLabel();
        PerroLblNombre = new javax.swing.JLabel();
        PerroLblPeso = new javax.swing.JLabel();
        PerroTxtNombre = new javax.swing.JTextField();
        PerroTxtComentarios = new javax.swing.JTextField();
        PerroBtnExaminar = new javax.swing.JButton();
        PerroLblFotoBoton = new javax.swing.JLabel();
        PerroSpinAltura = new javax.swing.JSpinner();
        PerroSpinPeso = new javax.swing.JSpinner();
        CalLblCentimetros = new javax.swing.JLabel();
        CalLblKilogramos = new javax.swing.JLabel();
        PerroComboPerros = new javax.swing.JComboBox<>();
        PerroBtnEditar = new javax.swing.JButton();
        PerroBtnGuardar = new javax.swing.JButton();
        PerroLblAdvertencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Pets");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMouseClicked(evt);
            }
        });

        CalDayChooser.setBorder(new javax.swing.border.MatteBorder(null));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CalMonthChooser, org.jdesktop.beansbinding.ELProperty.create("${month}"), CalDayChooser, org.jdesktop.beansbinding.BeanProperty.create("month"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CalYearChooser, org.jdesktop.beansbinding.ELProperty.create("${year}"), CalDayChooser, org.jdesktop.beansbinding.BeanProperty.create("year"));
        bindingGroup.addBinding(binding);

        CalDayChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalDayChooserPropertyChange(evt);
            }
        });

        CalMonthChooser.setBorder(new javax.swing.border.MatteBorder(null));
        CalMonthChooser.setToolTipText("");

        CalYearChooser.setBorder(new javax.swing.border.MatteBorder(null));

        CalLstActividades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CalLstActividadesValueChanged(evt);
            }
        });
        CalScrollActividades.setViewportView(CalLstActividades);

        CalBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnAgregarActionPerformed(evt);
            }
        });

        CalLblTipo.setText("Tipo de actividad:");

        CalLblUsuario.setText("Usuario:");

        CalLblPerro.setText("Perro:");

        CalLblFecha.setText("Fecha:");

        CalComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paseo", "Alimentación", "Otra" }));
        CalComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboTipoActionPerformed(evt);
            }
        });

        CalComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahora", "Personalizado" }));
        CalComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboHoraActionPerformed(evt);
            }
        });

        CalLblHora.setText("Hora");

        CalPanLblMinutos.setText("Minutos");

        CalPanSpinMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));

        CalPanSpinHora.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        CalPanLblHora.setText("Hora");

        javax.swing.GroupLayout CalPanHoraPersonalizadaLayout = new javax.swing.GroupLayout(CalPanHoraPersonalizada);
        CalPanHoraPersonalizada.setLayout(CalPanHoraPersonalizadaLayout);
        CalPanHoraPersonalizadaLayout.setHorizontalGroup(
            CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalPanLblHora)
                    .addComponent(CalPanLblMinutos))
                .addGap(18, 18, 18)
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CalPanSpinMinutos)
                    .addComponent(CalPanSpinHora))
                .addContainerGap())
        );
        CalPanHoraPersonalizadaLayout.setVerticalGroup(
            CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalPanLblHora)
                    .addComponent(CalPanSpinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalPanLblMinutos)
                    .addComponent(CalPanSpinMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        CalLblTituloFecha.setText("Fecha");

        CalLblTituloActividad.setText("Actividad");

        CalLblNombre.setText("Nombre:");

        CalTxtNombreResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalTxtNombreRespActionPerformed(evt);
            }
        });

        CalLblVeterinaria.setText("Veterinaria:");

        CalBtnGroupVeterinaria.add(CalBtnVeterinariaSi);
        CalBtnVeterinariaSi.setText("Si");
        CalBtnVeterinariaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVeterinariaSiActionPerformed(evt);
            }
        });

        CalBtnGroupVeterinaria.add(CalBtnVeterinariaNo);
        CalBtnVeterinariaNo.setText("No");
        CalBtnVeterinariaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVeterinariaNoActionPerformed(evt);
            }
        });

        CalComboVeterinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboVeterinariaActionPerformed(evt);
            }
        });

        CalLblMotivo.setText("Motivo:");

        CalComboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corte de Pelo", "Corte de Uñas", "Visita Médica", "Otro" }));

        javax.swing.GroupLayout CalPanVeterinariaLayout = new javax.swing.GroupLayout(CalPanVeterinaria);
        CalPanVeterinaria.setLayout(CalPanVeterinariaLayout);
        CalPanVeterinariaLayout.setHorizontalGroup(
            CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CalLblHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                        .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalLblVeterinaria)
                            .addComponent(CalLblMotivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CalComboVeterinaria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CalComboMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                                .addComponent(CalBtnVeterinariaSi)
                                .addGap(18, 18, 18)
                                .addComponent(CalBtnVeterinariaNo)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        CalPanVeterinariaLayout.setVerticalGroup(
            CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalLblVeterinaria)
                    .addComponent(CalBtnVeterinariaSi)
                    .addComponent(CalBtnVeterinariaNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalComboVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalLblMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalLblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CalTxtTipoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalTxtTipoAlimentoActionPerformed(evt);
            }
        });

        CalLblTipoAlimento.setText("Tipo Alimento:");

        CalLblActividadesDelDia.setText("Actividades del Día:");

        CalTxtAreaInfoAct.setColumns(20);
        CalTxtAreaInfoAct.setRows(5);
        CalScrollInfoAct.setViewportView(CalTxtAreaInfoAct);

        CalLblInfoActividad.setText("Información de la Actividad: ");

        CalBtnEditar.setText("Editar");
        CalBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnEditarActionPerformed(evt);
            }
        });

        CalLblRealizada.setText("Fue realizada:");

        CalBtnGroupRealizada.add(CalBtnRealizadaSi);
        CalBtnRealizadaSi.setText("Si");
        CalBtnRealizadaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRealizadaSiActionPerformed(evt);
            }
        });

        CalBtnGroupRealizada.add(CalBtnRealizadaNo);
        CalBtnRealizadaNo.setText("No");
        CalBtnRealizadaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRealizadaNoActionPerformed(evt);
            }
        });

        CalSpinDistancia.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        CalLblKilometros.setText("Kilómetros");

        CalBtnRuta.setText("Agregar Ruta");
        CalBtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRutaActionPerformed(evt);
            }
        });

        CalLblRuta.setText("Ruta:");

        CalLblDistancia.setText("Distancia:");

        javax.swing.GroupLayout CalPanRutaLayout = new javax.swing.GroupLayout(CalPanRuta);
        CalPanRuta.setLayout(CalPanRutaLayout);
        CalPanRutaLayout.setHorizontalGroup(
            CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanRutaLayout.createSequentialGroup()
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalLblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CalLblDistancia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CalPanRutaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(CalSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalLblKilometros))
                    .addGroup(CalPanRutaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(CalBtnRuta)))
                .addContainerGap())
        );
        CalPanRutaLayout.setVerticalGroup(
            CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CalPanRutaLayout.createSequentialGroup()
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalBtnRuta)
                    .addComponent(CalLblRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalLblKilometros)
                    .addComponent(CalLblDistancia))
                .addGap(49, 49, 49))
        );

        CalBtnAgregarDatos.setText("Agregar Datos Precargados");
        CalBtnAgregarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnAgregarDatosActionPerformed(evt);
            }
        });

        CalBtnVerRuta.setText("Ver Ruta");
        CalBtnVerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVerRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCalendarioLayout = new javax.swing.GroupLayout(panCalendario);
        panCalendario.setLayout(panCalendarioLayout);
        panCalendarioLayout.setHorizontalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(CalLblActividadesDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                                        .addComponent(CalScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CalLblInfoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalScrollInfoAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(CalMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CalYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(CalLblTituloFecha)))
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(CalBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(CalBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(CalBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(CalPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CalBtnVerRuta))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(CalTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCalendarioLayout.createSequentialGroup()
                                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(CalLblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(CalLblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(CalLblPerro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(CalLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(CalLblHora))
                                                        .addComponent(CalLblNombre))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(CalComboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(CalComboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(CalComboPerro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(CalLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(CalTxtNombreResp)
                                                        .addComponent(CalComboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(CalLblRealizada)
                                                    .addComponent(CalLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addComponent(CalBtnRealizadaSi)
                                                .addGap(18, 18, 18)
                                                .addComponent(CalBtnRealizadaNo)))
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CalPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CalPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CalLblTituloActividad)
                        .addGap(291, 291, 291))))
        );
        panCalendarioLayout.setVerticalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblTipo)
                                    .addComponent(CalComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblNombre)
                                    .addComponent(CalTxtNombreResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblUsuario)
                                    .addComponent(CalComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(CalPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblPerro)
                            .addComponent(CalComboPerro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CalLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CalLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblHora)
                                    .addComponent(CalComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblRealizada)
                                    .addComponent(CalBtnRealizadaSi)
                                    .addComponent(CalBtnRealizadaNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CalPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalBtnVerRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CalBtnEditar)
                        .addGap(12, 12, 12)
                        .addComponent(CalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalBtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CalBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblTituloFecha)
                            .addComponent(CalLblTituloActividad))
                        .addGap(3, 3, 3)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblActividadesDelDia)
                            .addComponent(CalLblInfoActividad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(CalScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CalScrollInfoAct))))
                .addGap(326, 326, 326))
        );

        Panel.addTab("Calendario", panCalendario);

        UsuarioLblUsuarios.setText("Usuario");

        UsuarioComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioComboUsuariosActionPerformed(evt);
            }
        });

        UsuarioLblNombre.setText("Nombre:");

        UsuarioLblMail.setText("Mail:");

        UsuarioTxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioTxtMailActionPerformed(evt);
            }
        });

        UsuarioBtnAgregar.setText("Agregar Usuario");
        UsuarioBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioBtnAgregarActionPerformed(evt);
            }
        });

        UsuarioLblActividades.setText("Próximas Actividades");

        UsuarioScrollActividades.setViewportView(UsuarioLstActividades);

        UsuarioLblActividad.setText("Activiad:");

        UsuarioLblFecha.setText("Fecha");

        UsuarioScrollFechas.setViewportView(UsuarioLstFechas);

        javax.swing.GroupLayout panUsuariosLayout = new javax.swing.GroupLayout(panUsuarios);
        panUsuarios.setLayout(panUsuariosLayout);
        panUsuariosLayout.setHorizontalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblUsuarios)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panUsuariosLayout.createSequentialGroup()
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(UsuarioLblNombre)
                                            .addComponent(UsuarioLblMail))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(UsuarioTxtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(UsuarioTxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(UsuarioLblAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(39, 39, 39))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(UsuarioBtnAgregar)
                        .addGap(102, 102, 102)))
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsuarioLblActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblActividad)
                            .addComponent(UsuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblFecha)
                            .addComponent(UsuarioScrollFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(89, 89, 89))
        );
        panUsuariosLayout.setVerticalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsuarioLblNombre)
                            .addComponent(UsuarioTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsuarioTxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsuarioLblMail))
                        .addGap(18, 18, 18)
                        .addComponent(UsuarioLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioBtnAgregar))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioLblActividades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UsuarioLblActividad)
                                    .addComponent(UsuarioLblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UsuarioScrollFechas)
                                    .addComponent(UsuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioLblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UsuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        Panel.addTab("Usuarios", panUsuarios);

        PerroBtnAgregar.setText("Ingresar Perro");
        PerroBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroBtnAgregarActionPerformed(evt);
            }
        });

        PerroLblPerros.setText("Perros");

        javax.swing.GroupLayout PerroPanFotoLayout = new javax.swing.GroupLayout(PerroPanFoto);
        PerroPanFoto.setLayout(PerroPanFotoLayout);
        PerroPanFotoLayout.setHorizontalGroup(
            PerroPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerroPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PerroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PerroPanFotoLayout.setVerticalGroup(
            PerroPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerroPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PerroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PerroLblAltura.setText("Altura");

        PerroLblComentarios.setText("Comentarios");

        PerroLblNombre.setText("Nombre");

        PerroLblPeso.setText("Peso");

        PerroTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroTxtNombreActionPerformed(evt);
            }
        });

        PerroBtnExaminar.setText("Examinar");
        PerroBtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroBtnExaminarActionPerformed(evt);
            }
        });

        PerroLblFotoBoton.setText("Foto:");

        PerroSpinAltura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        PerroSpinPeso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        CalLblCentimetros.setText("Centímetros");

        CalLblKilogramos.setText("Kilogramos");

        javax.swing.GroupLayout PerroPanInformacionLayout = new javax.swing.GroupLayout(PerroPanInformacion);
        PerroPanInformacion.setLayout(PerroPanInformacionLayout);
        PerroPanInformacionLayout.setHorizontalGroup(
            PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerroPanInformacionLayout.createSequentialGroup()
                .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PerroTxtComentarios))
                    .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PerroPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PerroLblComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                                .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PerroLblNombre)
                                    .addComponent(PerroLblAltura))
                                .addGap(26, 26, 26)
                                .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PerroTxtNombre)
                                    .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(PerroSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PerroSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CalLblCentimetros)
                                            .addComponent(CalLblKilogramos))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                                .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PerroLblPeso)
                                    .addComponent(PerroLblFotoBoton))
                                .addGap(42, 42, 42)
                                .addComponent(PerroBtnExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PerroPanInformacionLayout.setVerticalGroup(
            PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PerroLblNombre)
                            .addComponent(PerroTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PerroLblAltura)
                            .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PerroSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CalLblCentimetros)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PerroLblPeso)
                            .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PerroSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CalLblKilogramos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PerroPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PerroBtnExaminar)
                            .addComponent(PerroLblFotoBoton)))
                    .addGroup(PerroPanInformacionLayout.createSequentialGroup()
                        .addComponent(PerroPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PerroLblComentarios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PerroTxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PerroComboPerros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PerroComboPerrosMouseClicked(evt);
            }
        });
        PerroComboPerros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroComboPerrosActionPerformed(evt);
            }
        });

        PerroBtnEditar.setText("Editar");
        PerroBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroBtnEditarActionPerformed(evt);
            }
        });

        PerroBtnGuardar.setText("Guardar");
        PerroBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerroBtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPerrosLayout = new javax.swing.GroupLayout(panPerros);
        panPerros.setLayout(panPerrosLayout);
        panPerrosLayout.setHorizontalGroup(
            panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPerrosLayout.createSequentialGroup()
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PerroLblPerros)
                            .addComponent(PerroComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPerrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PerroBtnEditar)
                        .addGap(22, 22, 22)))
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PerroBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PerroBtnAgregar)))
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPerrosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(PerroLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PerroPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        panPerrosLayout.setVerticalGroup(
            panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPerrosLayout.createSequentialGroup()
                .addGroup(panPerrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(PerroLblPerros)
                        .addGap(18, 18, 18)
                        .addComponent(PerroComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PerroBtnEditar))
                    .addGroup(panPerrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PerroPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(PerroLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PerroBtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PerroBtnAgregar)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        Panel.addTab("Perros", panPerros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PerroBtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroBtnExaminarActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenAgregar = imgSeleccionada.getAbsolutePath();
            PerroLblFoto.setIcon(crearIcono(imgSeleccionada, 100));
        } else {
            PerroLblAdvertencia.setText("No se ha podido ingresar la imágen de forma correcta");
        }
    }//GEN-LAST:event_PerroBtnExaminarActionPerformed

    private void PerroTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerroTxtNombreActionPerformed

    private void PerroBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroBtnAgregarActionPerformed
        if (agregarPerroSeleccionado == false) {
            mostrarAgregarPerro();
        } else {
            if (PerroTxtNombre.getText().equals("")) {
                PerroLblAdvertencia.setText("Por favor ingrese un nombre");
            } else if (PerroSpinAltura.getValue().equals(0)) {
                PerroLblAdvertencia.setText("Por favor ingrese una altura válida");
            } else if (PerroSpinPeso.getValue().equals(0.0)) {
                PerroLblAdvertencia.setText("Por favor ingrese un peso válido");
            } else {
                Animal perroAgregar = new Animal(PerroTxtNombre.getText(), Integer.parseInt(PerroSpinAltura.getValue().toString()), Double.parseDouble(PerroSpinPeso.getValue().toString()), PerroTxtComentarios.getText());
                if (rutaImagenAgregar.equals("")) {
                    try {
                        perroAgregar.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource(RUTA_IMAGEN_PERRO_POR_DEFECTO)).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                } else {
                    File imagen = new File(rutaImagenAgregar);
                    perroAgregar.setFoto(crearIcono(imagen, 100));
                    rutaImagenAgregar = "";
                }
                sistema.addAnimal(perroAgregar);
                PerroTxtNombre.setText("");
                PerroSpinPeso.setValue((Object) 0.0);
                PerroSpinAltura.setValue((Object) 0.0);
                PerroTxtComentarios.setText("");
                PerroLblAdvertencia.setText("");
                ocultarAgregarPerro();
                setearListaPerros();
            }
        }
    }//GEN-LAST:event_PerroBtnAgregarActionPerformed

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    private void UsuarioBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioBtnAgregarActionPerformed
        if (agregarUsuarioSeleccionado == false) {
            mostrarAgregarUsuario();
        } else {
            if (UsuarioTxtNombre.getText().equals("")) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un nombre para el usuario");
            } else if (UsuarioTxtMail.getText().equals("")) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un email para el usuario");
            } else if (!isValidEmailAddress(UsuarioTxtMail.getText())) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un email correcto");
            } else {
                Responsable usuarioAgregar = new Responsable(UsuarioTxtNombre.getText(), UsuarioTxtMail.getText());
                sistema.addResponsable(usuarioAgregar);
                UsuarioTxtNombre.setText("");
                UsuarioTxtMail.setText("");
                ocultarAgregarUsuario();
                resetearListaUsuarios();
                UsuarioLblAdvertencia.setText("");
            }
        }
    }//GEN-LAST:event_UsuarioBtnAgregarActionPerformed

    private void UsuarioComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioComboUsuariosActionPerformed
        ocultarAgregarUsuario();
        if (UsuarioComboUsuarios.getItemCount() > 0) {
            Responsable usuarioSeleccionado = sistema.getResponsable(UsuarioComboUsuarios.getSelectedItem().toString());
            UsuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            UsuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
            String[] arrayActividades = new String[5];
            String[] arrayFechas = new String[5];
            int cantidadActividades = usuarioSeleccionado.getActividades().size();
            for (int i = 0; i < cantidadActividades; i++) {
                arrayActividades[i] = usuarioSeleccionado.getActividades().get(i).getNombre();
                Fecha fechaActividad = usuarioSeleccionado.getActividades().get(i).getFecha();
                arrayFechas[i] = fechaActividad.getDia() + "/" + fechaActividad.getMes() + "/" + fechaActividad.getAno();
            }
            UsuarioLstActividades.setListData(arrayActividades);
            UsuarioLstFechas.setListData(arrayFechas);
        } else {
            UsuarioLblNombre.setText("Nombre: ");
            UsuarioLblMail.setText("Mail: ");
            String[] arrayVacio = new String[0];
            UsuarioLstActividades.setListData(arrayVacio);
            UsuarioLstFechas.setListData(arrayVacio);
        }
    }//GEN-LAST:event_UsuarioComboUsuariosActionPerformed

    private void setearListaDeVeterinarias() {
        if (CalComboVeterinaria.getItemCount() > 0) {
            CalComboVeterinaria.removeAllItems();
        }
        for (int i = 0; i < sistema.getVeterinarias().size(); i++) {
            CalComboVeterinaria.addItem(sistema.getVeterinarias().get(i).getNombre());
        }
    }

    private void mostrarAgregarPerro() {
        agregarPerroSeleccionado = true;
        PerroLblNombre.setText("Nombre:");
        PerroLblPeso.setText("Peso:");
        PerroLblAltura.setText("Altura:");
        PerroLblComentarios.setText("Comentarios:");
        PerroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
        PerroTxtNombre.setVisible(true);
        PerroSpinPeso.setVisible(true);
        PerroSpinAltura.setVisible(true);
        PerroTxtComentarios.setVisible(true);
        PerroLblFotoBoton.setVisible(true);
        PerroBtnExaminar.setVisible(true);
    }

    private void ocultarAgregarPerro() {
        PerroTxtNombre.setVisible(false);
        PerroTxtNombre.setText("");
        PerroSpinPeso.setVisible(false);
        PerroSpinPeso.setValue((Object) 0.0);
        PerroSpinAltura.setVisible(false);
        PerroSpinAltura.setValue((Object) 0.0);
        PerroTxtComentarios.setVisible(false);
        PerroTxtComentarios.setText("");
        PerroLblFotoBoton.setVisible(false);
        PerroBtnExaminar.setVisible(false);
        agregarPerroSeleccionado = false;
    }

    private void mostrarEditarPerro() {
        PerroBtnGuardar.setVisible(true);
        PerroBtnAgregar.setVisible(false);
        agregarPerroSeleccionado = true;
        PerroLblNombre.setText("Nombre:");
        PerroLblPeso.setText("Peso:");
        PerroLblAltura.setText("Altura:");
        PerroLblComentarios.setText("Comentarios:");
        Animal perroSeleccionado = sistema.getAnimal(PerroComboPerros.getSelectedItem().toString());
        PerroLblFoto.setIcon(perroSeleccionado.getFoto());
        PerroTxtNombre.setText(perroSeleccionado.getNombre());
        PerroSpinPeso.setValue(perroSeleccionado.getPeso());
        PerroSpinAltura.setValue(perroSeleccionado.getAltura());
        PerroTxtComentarios.setText("" + perroSeleccionado.getComentarios());
        PerroTxtNombre.setVisible(true);
        PerroSpinPeso.setVisible(true);
        PerroSpinAltura.setVisible(true);
        PerroTxtComentarios.setVisible(true);
        PerroLblFotoBoton.setVisible(true);
        PerroBtnExaminar.setVisible(true);
    }

    private void setearListaPerros() {
        if (PerroComboPerros.getItemCount() > 0) {
            PerroComboPerros.removeAllItems();
        }
        if (CalComboPerro.getItemCount() > 0) {
            CalComboPerro.removeAllItems();
        }
        for (int i = 0; i < sistema.getAnimales().size(); i++) {
            PerroComboPerros.addItem(sistema.getAnimales().get(i).getNombre());
            CalComboPerro.addItem(sistema.getAnimales().get(i).getNombre());
        }

    }

    private void mostrarAgregarUsuario() {
        agregarUsuarioSeleccionado = true;
        UsuarioLblNombre.setText("Nombre:");
        UsuarioLblMail.setText("Mail:");
        UsuarioTxtNombre.setVisible(true);
        UsuarioTxtMail.setVisible(true);
    }

    private void ocultarAgregarUsuario() {
        UsuarioTxtNombre.setVisible(false);
        UsuarioTxtMail.setVisible(false);
        agregarUsuarioSeleccionado = false;
    }

    private void resetearListaUsuarios() {
        if (UsuarioComboUsuarios.getItemCount() > 0) {
            UsuarioComboUsuarios.removeAllItems();
        }
        if (CalComboUsuario.getItemCount() > 0) {
            CalComboUsuario.removeAllItems();
        }
        for (int i = 0; i < sistema.getResponsables().size(); i++) {
            UsuarioComboUsuarios.addItem(sistema.getResponsables().get(i).getNombre());
            CalComboUsuario.addItem(sistema.getResponsables().get(i).getNombre());
        }
    }

    private void UsuarioTxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioTxtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioTxtMailActionPerformed

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelMouseClicked

    private void PerroComboPerrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PerroComboPerrosMouseClicked

    }//GEN-LAST:event_PerroComboPerrosMouseClicked

    private void PerroComboPerrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroComboPerrosActionPerformed
        ocultarAgregarPerro();
        if (PerroComboPerros.getItemCount() > 0) {
            Animal perroSeleccionado = sistema.getAnimal(PerroComboPerros.getSelectedItem().toString());
            PerroLblNombre.setText(perroSeleccionado.getNombre().toUpperCase());
            PerroLblPeso.setText("Pesa:       " + perroSeleccionado.getPeso());
            PerroLblAltura.setText("Mide:       " + perroSeleccionado.getAltura());
            PerroLblComentarios.setText("" + perroSeleccionado.getComentarios());
            PerroLblFoto.setIcon(perroSeleccionado.getFoto());
            PerroBtnGuardar.setVisible(false);
            PerroBtnEditar.setVisible(true);
            PerroBtnAgregar.setVisible(true);
        } else {
            PerroLblNombre.setText("Nombre: ");
            PerroLblPeso.setText("Peso ");
            PerroLblAltura.setText("Altura: ");
            PerroLblComentarios.setText("Comentarios: ");
            try {
                PerroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource(RUTA_IMAGEN_PERRO_POR_DEFECTO)).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_PerroComboPerrosActionPerformed

    private void PerroBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroBtnEditarActionPerformed
        mostrarEditarPerro();
    }//GEN-LAST:event_PerroBtnEditarActionPerformed

    private void PerroBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerroBtnGuardarActionPerformed
        Animal perroSeleccionado = sistema.getAnimal(PerroComboPerros.getSelectedItem().toString());
        String valor = PerroSpinAltura.getValue() + "";
        double altura = Double.parseDouble(valor);
        perroSeleccionado.setAltura(altura);
        perroSeleccionado.setComentarios(PerroTxtComentarios.getText());
        perroSeleccionado.setNombre(PerroTxtNombre.getText());
        valor = PerroSpinPeso.getValue() + "";
        double peso = Double.parseDouble(valor);
        perroSeleccionado.setPeso(peso);
        if (!rutaImagenAgregar.equals("")) {
            File imagen = new File(rutaImagenAgregar);
            perroSeleccionado.setFoto(crearIcono(imagen, 100));
            rutaImagenAgregar = "";
        }
        ocultarAgregarPerro();
        int pos = PerroComboPerros.getSelectedIndex();
        setearListaPerros();
        PerroComboPerros.setSelectedIndex(pos);
    }//GEN-LAST:event_PerroBtnGuardarActionPerformed

    private void CalBtnAgregarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnAgregarDatosActionPerformed
        try {
            Responsable persona = new Responsable("Alex", "alexkmass@gmail.com");
            sistema.addResponsable(persona);
            Animal rasta = new Animal("Rasta", 50, 23, "Es un buen perro, le gusta comer");
            rasta.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource(RUTA_IMAGEN_PERRO_POR_DEFECTO)).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.addAnimal(rasta);
            Responsable persona2 = new Responsable("Marcelo", "marcelo@gmail.com");
            sistema.addResponsable(persona2);
            Animal ori = new Animal("Ori", 50, 23, "Es un buen perro");
            ori.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroFoto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.addAnimal(ori);
            Fecha fecha = new Fecha(22, 11, 2018);
            sistema.anadirFecha(fecha);
            LocalTime hora = LocalTime.now();
            Paseo act = new Paseo("Paseo Rasta", rasta, persona, false, fecha, hora, 0.0, null);
            act.setRuta(new ImageIcon(ImageIO.read(this.getClass().getResource("images/rutaPorDefecto.png")).getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
            sistema.addActividad(act);
            hora = LocalTime.now();
            Alimentacion act2 = new Alimentacion("Alimentación de Ori", persona, ori, "DogChow", false, hora, fecha);
            sistema.addActividad(act2);
            OtraActividad act3 = new OtraActividad("Ir a una cita con Rasta", persona, rasta, true, hora, fecha);
            sistema.addActividad(act3);
            Veterinaria vet1 = new Veterinaria("Pocitos", new ArrayList<>(), 8, 16);
            sistema.getVeterinarias().add(vet1);
            Veterinaria vet2 = new Veterinaria("Carrasco", new ArrayList<>(), 10, 15);
            sistema.getVeterinarias().add(vet2);
            Veterinaria vet3 = new Veterinaria("Cordon", new ArrayList<>(), 8, 23);
            sistema.getVeterinarias().add(vet3);
            //VisitaVeterinaria visita = new VisitaVeterinaria("Visita a VetCordon", rasta, hora, persona, rasta, false, fecha, vet3, "Rasta tiene fiebre");
            //sistema.anadirActividad(visita);
            //sistema.getVisitas().add(visita);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        resetearPestanaPerros();
        inicializarPestanaUsuarios();
        setearListaDeVeterinarias();
        CalBtnAgregarDatos.setVisible(false);
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = (ArrayList) sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalBtnAgregarDatosActionPerformed

    private void CalBtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRutaActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenRuta = imgSeleccionada.getAbsolutePath();
        } else {
            CalLblAdvertencia.setText("No se pudo ingresar la ruta correctamente");
        }
    }//GEN-LAST:event_CalBtnRutaActionPerformed

    private void CalBtnRealizadaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRealizadaNoActionPerformed
        CalPanRuta.setVisible(false);
    }//GEN-LAST:event_CalBtnRealizadaNoActionPerformed

    private void CalBtnRealizadaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRealizadaSiActionPerformed
        if (CalComboTipo.getSelectedIndex() == 0) {
            CalPanRuta.setVisible(true);
        } else {
            CalPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_CalBtnRealizadaSiActionPerformed

    private void CalBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnEditarActionPerformed
        CalLstActividades.setEnabled(false);
        String nombreAct = CalLstActividades.getSelectedValue();
        Paseo paseo = sistema.getPaseo(nombreAct);
        CalBtnVeterinariaNo.setSelected(true);
        CalBtnVeterinariaNoActionPerformed(evt);
        CalBtnGroupRealizada.clearSelection();
        CalBtnRealizadaNo.setSelected(true);
        if (paseo != null) {
            if (paseo.getFueRealizado()) {
                CalBtnRealizadaSi.setSelected(true);
            }
            CalPanRuta.setVisible(true);
            CalComboTipo.setSelectedIndex(0);
            if (paseo.getFueRealizado()) {
                CalPanRuta.setVisible(true);
            }
            if (paseo.getRuta() == null) {
                CalBtnVerRuta.setVisible(false);
            }
            CalTxtNombreResp.setText(nombreAct);
            CalComboUsuario.setSelectedItem(paseo.getUsuario().getNombre());
            CalComboPerro.setSelectedItem(paseo.getMascota().getNombre());
            CalLblFechaResp.setText(paseo.getFecha().getDia() + "/" + paseo.getFecha().getMes() + "/" + paseo.getFecha().getAno());
            CalComboHora.setSelectedIndex(1);
            int hora = paseo.getHora().getHour();
            String horaString = "" + hora;
            if (hora < 10) {
                horaString = "0" + horaString;
            }
            CalPanSpinHora.setValue((Object) horaString);
            CalPanSpinMinutos.setValue(paseo.getHora().getMinute());
            sistema.eliminarActividad(paseo);
        } else {
            Alimentacion alim = sistema.getAlimentacion(nombreAct);
            if (alim != null) {
                if (alim.getFueRealizado()) {
                    CalBtnRealizadaSi.setSelected(true);
                }
                CalComboTipo.setSelectedIndex(1);
                CalTxtNombreResp.setText(nombreAct);
                CalComboUsuario.setSelectedItem(alim.getUsuario().getNombre());
                CalComboPerro.setSelectedItem(alim.getMascota().getNombre());
                CalLblFechaResp.setText(alim.getFecha().getDia() + "/" + alim.getFecha().getMes() + "/" + alim.getFecha().getAno());
                CalComboHora.setSelectedIndex(1);
                int hora = alim.getHora().getHour();
                String horaString = "" + hora;
                if (hora < 10) {
                    horaString = "0" + horaString;
                }
                CalPanSpinHora.setValue((Object) horaString);
                CalPanSpinMinutos.setValue(alim.getHora().getMinute());
                CalTxtTipoAlimento.setText(alim.getTipoAlimento());
                CalTxtTipoAlimento.setVisible(true);
                sistema.eliminarActividad(alim);
            } else {
                VisitaVeterinaria visita = sistema.getVisita(nombreAct);
                if (visita != null) {
                    if (visita.getFueRealizado()) {
                        CalBtnRealizadaSi.setSelected(true);
                    }
                    CalComboTipo.setSelectedIndex(2);
                    CalTxtNombreResp.setText(nombreAct);
                    CalComboUsuario.setSelectedItem(visita.getUsuario().getNombre());
                    CalComboPerro.setSelectedItem(visita.getMascota().getNombre());
                    CalLblFechaResp.setText(visita.getFecha().getDia() + "/" + visita.getFecha().getMes() + "/" + visita.getFecha().getAno());
                    CalComboHora.setSelectedIndex(1);
                    int hora = visita.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    CalPanSpinHora.setValue((Object) horaString);
                    CalPanSpinMinutos.setValue(visita.getHora().getMinute());
                    CalBtnVeterinariaSi.setSelected(true);
                    CalComboVeterinaria.setSelectedItem(visita.getVeterinaria().getNombre());
                    CalComboMotivo.setSelectedItem(visita.getMotivo());
                    CalPanVeterinaria.setVisible(true);
                    CalLblHorarios.setVisible(true);
                    visita.getVeterinaria().getActividadesAgendadas().remove(visita);
                    sistema.eliminarActividad(visita);
                } else {
                    OtraActividad actividad = sistema.getOtraActividad(nombreAct);
                    if (actividad.getFueRealizado()) {
                        CalBtnRealizadaSi.setSelected(true);
                    }
                    CalComboTipo.setSelectedIndex(2);
                    CalTxtNombreResp.setText(nombreAct);
                    CalComboUsuario.setSelectedItem(actividad.getUsuario().getNombre());
                    CalComboPerro.setSelectedItem(actividad.getMascota().getNombre());
                    CalLblFechaResp.setText(actividad.getFecha().getDia() + "/" + actividad.getFecha().getMes() + "/" + actividad.getFecha().getAno());
                    CalComboHora.setSelectedIndex(1);
                    int hora = actividad.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    CalPanSpinHora.setValue((Object) horaString);
                    CalPanSpinMinutos.setValue(actividad.getHora().getMinute());
                    CalTxtTipoAlimento.setVisible(true);
                    sistema.eliminarActividad(actividad);
                }
            }
        }
        CalLblAdvertencia.setText("Edite la actividad y agreguela");
        CalBtnEditar.setVisible(false);
    }//GEN-LAST:event_CalBtnEditarActionPerformed

    private void CalTxtTipoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalTxtTipoAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalTxtTipoAlimentoActionPerformed

    private void CalComboVeterinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboVeterinariaActionPerformed
        Veterinaria vet = sistema.getVeterinaria((String) CalComboVeterinaria.getSelectedItem());
        CalLblHorarios.setVisible(true);
        CalLblHorarios.setText("Horarios: " + vet.getHoraInicial() + " - " + vet.getHoraFinal());
    }//GEN-LAST:event_CalComboVeterinariaActionPerformed

    private void CalBtnVeterinariaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVeterinariaNoActionPerformed
        CalComboVeterinaria.setVisible(false);
        CalComboMotivo.setVisible(false);
        CalLblMotivo.setVisible(false);
        CalLblHorarios.setVisible(false);
    }//GEN-LAST:event_CalBtnVeterinariaNoActionPerformed

    private void CalBtnVeterinariaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVeterinariaSiActionPerformed
        CalComboVeterinaria.setVisible(true);
        CalComboMotivo.setVisible(true);
        CalLblMotivo.setVisible(true);
        CalLblHorarios.setVisible(true);
    }//GEN-LAST:event_CalBtnVeterinariaSiActionPerformed

    private void CalTxtNombreRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalTxtNombreRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalTxtNombreRespActionPerformed

    private void CalComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboHoraActionPerformed
        if (CalComboHora.getSelectedIndex() == 0) {
            CalPanHoraPersonalizada.setVisible(false);
        } else {
            CalPanHoraPersonalizada.setVisible(true);
        }
    }//GEN-LAST:event_CalComboHoraActionPerformed

    private void CalComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboTipoActionPerformed
        if (CalComboTipo.getSelectedIndex() == 2) {
            if (CalBtnVeterinariaSi.isSelected()) {
                cambiarVisibilidadVeterinaria(true, true);
            } else {
                cambiarVisibilidadVeterinaria(true, false);
            }
        } else {
            cambiarVisibilidadVeterinaria(false, false);
        }
        if (CalComboTipo.getSelectedIndex() == 1) {
            CalLblTipoAlimento.setVisible(true);
            CalTxtTipoAlimento.setVisible(true);
        } else {
            CalLblTipoAlimento.setVisible(false);
            CalTxtTipoAlimento.setVisible(false);
            CalTxtTipoAlimento.setText("");
        }
        if (CalComboTipo.getSelectedIndex() == 0 && CalBtnRealizadaSi.isSelected()) {
            CalPanRuta.setVisible(true);
        } else {
            CalPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_CalComboTipoActionPerformed

    private void CalBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnAgregarActionPerformed
        String nombreAct = CalTxtNombreResp.getText();
        boolean fueRealizada = true;
        if (CalBtnRealizadaNo.isSelected()) {
            fueRealizada = false;
        }
        if (nombreAct.equals("")) {
            CalLblAdvertencia.setText("No se ingresó un nombre, ingrese el nombre de la actividad.");
        } else if (CalComboUsuario.getItemCount() == 0) {
            CalLblAdvertencia.setText("Por favor, ingrese un usuario para agregar una actividad.");
        } else if (CalComboPerro.getItemCount() == 0) {
            CalLblAdvertencia.setText("Por favor, ingrese un perro para agregar una actividad.");
        } else {
            Responsable usuario = sistema.getResponsable((String) CalComboUsuario.getSelectedItem());
            Animal perro = sistema.getAnimal((String) CalComboPerro.getSelectedItem());
            LocalTime time;
            if (((String) CalComboHora.getSelectedItem()).equals("Ahora")) {
                time = LocalTime.now();
            } else {
                String hora = CalPanSpinHora.getValue() + "";
                String min = CalPanSpinMinutos.getValue() + "";
                time = LocalTime.of(Integer.parseInt(hora), Integer.parseInt(min));
            }
            if (CalBtnVeterinariaSi.isSelected()) {
                Veterinaria vet = sistema.getVeterinaria((String) CalComboVeterinaria.getSelectedItem());
                String motivo = (String) CalComboMotivo.getSelectedItem();
                VisitaVeterinaria visita = new VisitaVeterinaria(nombreAct, perro, usuario, fueRealizada, fechaSeleccionada, time, vet, motivo);
                if (vet.agendarActividad(visita)) {
                    sistema.addActividad(visita);
                    if (CalComboHora.getSelectedIndex() != 0) {
                        timerNuevo(visita);
                    }
                    CalLblAdvertencia.setText("Se agrego la visita a la veterinaria con éxito");
                    CalLstActividades.setEnabled(true);
                    CalBtnEditar.setVisible(false);
                    CalTxtNombreResp.setText("");
                    CalPanVeterinaria.setVisible(false);
                    CalLblHorarios.setVisible(false);
                } else {
                    CalLblAdvertencia.setText("La veterinaria no tiene horarios disponibles en ese horario, por favor ingrse una "
                            + "hora distinta entre las " + vet.getHoraInicial() + " y las " + vet.getHoraFinal());
                }
            } else {
                String tipoAct = (String) CalComboTipo.getSelectedItem();
                if (tipoAct.equals("Paseo")) {
                    Paseo paseo = new Paseo(nombreAct, perro, usuario, fueRealizada, fechaSeleccionada, time, 0, null);
                    double distanciaPaseo = Double.parseDouble(CalSpinDistancia.getValue().toString());
                    if (distanciaPaseo != 0.0) {
                        paseo.setDistancia(distanciaPaseo);
                    }
                    sistema.addActividad(paseo);
                    if (CalComboHora.getSelectedIndex() != 0) {
                        timerNuevo(paseo);
                    }
                    if (!rutaImagenRuta.equals("")) {
                        File imagen = new File(rutaImagenRuta);
                        paseo.setRuta(crearIcono(imagen, 500));
                        rutaImagenRuta = "";
                    }
                    CalLblAdvertencia.setText("Se añadió el paseo correctamente al calendario");
                    CalLstActividades.setEnabled(true);
                    CalTxtNombreResp.setText("");
                    CalBtnEditar.setVisible(false);
                    CalPanRuta.setVisible(false);
                } else {
                    if (tipoAct.equals("Alimentación")) {
                        String tipoAlimento = CalTxtTipoAlimento.getText();
                        if (tipoAlimento.equals("")) {
                            CalLblAdvertencia.setText("No se ingresó el tipo del alimento, ingrse el tipo del alimento");
                        } else {
                            Alimentacion alim = new Alimentacion(nombreAct, usuario, perro, tipoAlimento, fueRealizada, time, fechaSeleccionada);
                            sistema.addActividad(alim);
                            if (CalComboHora.getSelectedIndex() != 0) {
                                timerNuevo(alim);
                            }
                            CalLblAdvertencia.setText("Se añadió la alimentación correctamente al calendario");
                            CalTxtNombreResp.setText("");
                            CalTxtTipoAlimento.setText("");
                            CalBtnEditar.setVisible(false);
                            CalLstActividades.setEnabled(true);
                        }
                    } else {
                        OtraActividad actividad = new OtraActividad(nombreAct, usuario, perro, fueRealizada, time, fechaSeleccionada);
                        sistema.addActividad(actividad);
                        if (CalComboHora.getSelectedIndex() != 0) {
                            timerNuevo(actividad);
                        }
                        CalLblAdvertencia.setText("Se añadió la actividad correctamente al calendario");
                        CalTxtNombreResp.setText("");
                        CalBtnEditar.setVisible(false);
                        CalLstActividades.setEnabled(true);
                    }
                }
            }
        }
        CalPanRuta.setVisible(false);
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = (ArrayList) sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalBtnAgregarActionPerformed

    private void CalLstActividadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CalLstActividadesValueChanged
        String nombreAct = CalLstActividades.getSelectedValue();
        String cero = "";
        CalBtnVerRuta.setVisible(false);
        if (nombreAct != null) {
            Paseo paseo = sistema.getPaseo(nombreAct);
            if (paseo != null) {
                CalBtnVerRuta.setVisible(true);
                if (paseo.getHora().getMinute() < 10) {
                    cero = "0";
                }
                String fueRealizada = "No";
                if (paseo.getFueRealizado()) {
                    fueRealizada = "Si";
                }
                if (paseo.getDistancia() == 0.0) {
                    CalTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                            + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                            + "Perro: " + paseo.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute());
                } else {
                    CalTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                            + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                            + "Perro: " + paseo.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute() + "\n"
                            + "Distancia: " + paseo.getDistancia() + "kilómetros");
                }
                if (paseo.getRuta() != null) {

                }
            } else {
                Alimentacion alim = sistema.getAlimentacion(nombreAct);
                if (alim != null) {
                    if (alim.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    String fueRealizada = "No";
                    if (alim.getFueRealizado()) {
                        fueRealizada = "Si";
                    }

                    CalTxtAreaInfoAct.setText("Nombre: " + alim.getNombre() + "\n"
                            + "Usuario responsable: " + alim.getUsuario().getNombre() + "\n"
                            + "Perro: " + alim.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Tipo Alimento: " + alim.getTipoAlimento() + "\n"
                            + "Hora: " + alim.getHora().getHour() + ":" + cero + alim.getHora().getMinute());
                } else {
                    VisitaVeterinaria visita = sistema.getVisita(nombreAct);
                    if (visita != null) {
                        if (visita.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (visita.getFueRealizado()) {
                            fueRealizada = "Si";
                        }
                        CalTxtAreaInfoAct.setText("Nombre: " + visita.getNombre() + "\n"
                                + "Usuario responsable: " + visita.getUsuario().getNombre() + "\n"
                                + "Perro: " + visita.getMascota().getNombre() + "\n"
                                + "Realizada: " + fueRealizada + "\n"
                                + "Motivo: " + visita.getMotivo() + "\n"
                                + "Veterinaria: " + visita.getVeterinaria().getNombre() + "\n"
                                + "Hora: " + visita.getHora().getHour() + ":" + cero + visita.getHora().getMinute());
                    } else {
                        OtraActividad act = sistema.getOtraActividad(nombreAct);
                        if (act.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (act.getFueRealizado()) {
                            fueRealizada = "Si";
                        }

                        CalTxtAreaInfoAct.setText("Nombre: " + act.getNombre() + "\n"
                                + "Usuario responsable: " + act.getUsuario().getNombre() + "\n"
                                + "Perro: " + act.getMascota().getNombre() + "\n"
                                + "Realizada: " + fueRealizada + "\n"
                                + "Hora: " + act.getHora().getHour() + ":" + cero + act.getHora().getMinute());
                    }
                }
            }
            CalBtnEditar.setVisible(true);
        } else {
            CalTxtAreaInfoAct.setText("Seleccione un paseo para" + "\n"
                    + "poder ver su información");
        }
    }//GEN-LAST:event_CalLstActividadesValueChanged

    private void CalDayChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalDayChooserPropertyChange
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = (ArrayList) sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalDayChooserPropertyChange

    private void CalBtnVerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVerRutaActionPerformed
        String nombreAct = CalLstActividades.getSelectedValue();
        Paseo paseo = sistema.getPaseo(nombreAct);
        if (paseo != null) {
            if (paseo.getRuta() != null) {
                try {
                    new VentanaFotoRuta(paseo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                CalLblAdvertencia.setText("No hay ruta agregada a este paseo");
            }
        }
    }//GEN-LAST:event_CalBtnVerRutaActionPerformed

    private void cambiarVisibilidadVeterinaria(boolean opcionCombo, boolean usaVeterinaria) {
        CalPanVeterinaria.setVisible(opcionCombo);
        CalBtnVeterinariaSi.setSelected(usaVeterinaria);
        CalBtnVeterinariaNo.setSelected(!usaVeterinaria);
        CalComboVeterinaria.setVisible(usaVeterinaria);
        CalComboMotivo.setVisible(usaVeterinaria);
        CalLblMotivo.setVisible(usaVeterinaria);
        CalLblHorarios.setVisible(opcionCombo);
    }

    private ImageIcon crearIcono(String ruta, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(getClass().getResource(ruta)).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }

    private ImageIcon crearIcono(File file, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(file).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }

    private void enviarMail(Actividad actividad) {
        String nombreAct = actividad.getNombre();
        Paseo paseo = sistema.getPaseo(nombreAct);
        String tipoActividad;
        String cuerpo;
        String cero = "";
        if (paseo != null) {
            tipoActividad = "Paseo";
            if (actividad.getHora().getMinute() < 10) {
                cero = "0";
            }
            cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                    + "Te recordamos que debes pasear a "
                    + actividad.getMascota().getNombre() + " hoy a las "
                    + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                    + "No lo olvides!";
        } else {
            Alimentacion alimentacion = sistema.getAlimentacion(nombreAct);
            if (alimentacion != null) {
                tipoActividad = "Alimentacion";
                if (actividad.getHora().getMinute() < 10) {
                    cero = "0";
                }
                cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                        + "Te recordamos que debes alimentar a "
                        + actividad.getMascota().getNombre() + " con " + alimentacion.getTipoAlimento()
                        + " hoy a las " + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                        + "No lo olvides!";
            } else {
                VisitaVeterinaria visita = sistema.getVisita(nombreAct);
                if (visita != null) {
                    tipoActividad = "Visita a Veterinaria";
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes llevar a "
                            + visita.getMascota().getNombre() + "a la veterinaria " + visita.getVeterinaria().getNombre()
                            + "para realizar un/una " + visita.getMotivo() + " hoy a las "
                            + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                } else {
                    OtraActividad actividadCualquiera = sistema.getOtraActividad(nombreAct);
                    tipoActividad = "una Actividad";
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividadCualquiera.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes " + actividadCualquiera.getNombre() + " con "
                            + actividadCualquiera.getMascota().getNombre() + " hoy a las "
                            + actividadCualquiera.getHora().getHour() + ":" + cero + actividadCualquiera.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                }
            }
        }
        String asunto = "Recordatorio de " + tipoActividad + " de My Pet";

        final String username = "recordatoriosmypet@gmail.com";
        final String password = "canucanualex";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("recordatoriosmismascotas@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(actividad.getUsuario().getMail()));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void timerNuevo(final Actividad act) {
        int horaActividad = act.getHora().getHour() * 60 + act.getHora().getMinute();
        int horaActual = LocalTime.now().getHour() * 60 + LocalTime.now().getMinute();
        int tiempoRestanteMinutos = horaActividad - horaActual;
        try {
            ActionListener notificacion = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    enviarMail(act);
                    mostrarNotificacion(act);
                }
            };
            int tiempoRestanteMilisegundos = tiempoRestanteMinutos * 60000;
            Timer timer = new Timer(tiempoRestanteMilisegundos, notificacion);
            timer.setRepeats(false);
            timer.start();
        } catch (ArithmeticException e) {

        }
    }

    public void mostrarNotificacion(Actividad actividad) {
        String nombreAct = actividad.getNombre();
        Paseo paseo = sistema.getPaseo(nombreAct);
        String cuerpo;
        String cero = "";
        if (paseo != null) {
            if (actividad.getHora().getMinute() < 10) {
                cero = "0";
            }
            cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                    + "Te recordamos que debes pasear a "
                    + actividad.getMascota().getNombre() + " hoy a las "
                    + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                    + "No lo olvides!";
        } else {
            Alimentacion alimentacion = sistema.getAlimentacion(nombreAct);
            if (alimentacion != null) {
                if (actividad.getHora().getMinute() < 10) {
                    cero = "0";
                }
                cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                        + "Te recordamos que debes alimentar a "
                        + actividad.getMascota().getNombre() + " con " + alimentacion.getTipoAlimento()
                        + " hoy a las " + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                        + "No lo olvides!";
            } else {
                VisitaVeterinaria visita = sistema.getVisita(nombreAct);
                if (visita != null) {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes llevar a "
                            + visita.getMascota().getNombre() + "a la veterinaria " + visita.getVeterinaria().getNombre()
                            + "para realizar un/una " + visita.getMotivo() + " hoy a las "
                            + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                } else {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    OtraActividad actividadCualquiera = sistema.getOtraActividad(nombreAct);
                    cuerpo = "Hola " + actividadCualquiera.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes " + actividadCualquiera.getNombre() + " con "
                            + actividadCualquiera.getMascota().getNombre() + " hoy a las "
                            + actividadCualquiera.getHora().getHour() + ":" + cero + actividadCualquiera.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                }
            }
        }
        JFrame ventana = this;
        JOptionPane.showMessageDialog(ventana, cuerpo, "Notificación", 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalBtnAgregar;
    private javax.swing.JButton CalBtnAgregarDatos;
    private javax.swing.JButton CalBtnEditar;
    private javax.swing.ButtonGroup CalBtnGroupRealizada;
    private javax.swing.ButtonGroup CalBtnGroupRepetir;
    private javax.swing.ButtonGroup CalBtnGroupVeterinaria;
    private javax.swing.JRadioButton CalBtnRealizadaNo;
    private javax.swing.JRadioButton CalBtnRealizadaSi;
    private javax.swing.JButton CalBtnRuta;
    private javax.swing.JButton CalBtnVerRuta;
    private javax.swing.JRadioButton CalBtnVeterinariaNo;
    private javax.swing.JRadioButton CalBtnVeterinariaSi;
    private javax.swing.JComboBox<String> CalComboHora;
    private javax.swing.JComboBox<String> CalComboMotivo;
    private javax.swing.JComboBox<String> CalComboPerro;
    private javax.swing.JComboBox<String> CalComboTipo;
    private javax.swing.JComboBox<String> CalComboUsuario;
    private javax.swing.JComboBox<String> CalComboVeterinaria;
    private com.toedter.calendar.JDayChooser CalDayChooser;
    private javax.swing.JLabel CalLblActividadesDelDia;
    private javax.swing.JLabel CalLblAdvertencia;
    private javax.swing.JLabel CalLblCentimetros;
    private javax.swing.JLabel CalLblDistancia;
    private javax.swing.JLabel CalLblFecha;
    private javax.swing.JLabel CalLblFechaResp;
    private javax.swing.JLabel CalLblHora;
    private javax.swing.JLabel CalLblHorarios;
    private javax.swing.JLabel CalLblInfoActividad;
    private javax.swing.JLabel CalLblKilogramos;
    private javax.swing.JLabel CalLblKilometros;
    private javax.swing.JLabel CalLblMotivo;
    private javax.swing.JLabel CalLblNombre;
    private javax.swing.JLabel CalLblPerro;
    private javax.swing.JLabel CalLblRealizada;
    private javax.swing.JLabel CalLblRuta;
    private javax.swing.JLabel CalLblTipo;
    private javax.swing.JLabel CalLblTipoAlimento;
    private javax.swing.JLabel CalLblTituloActividad;
    private javax.swing.JLabel CalLblTituloFecha;
    private javax.swing.JLabel CalLblUsuario;
    private javax.swing.JLabel CalLblVeterinaria;
    private javax.swing.JList<String> CalLstActividades;
    private com.toedter.calendar.JMonthChooser CalMonthChooser;
    private javax.swing.JPanel CalPanHoraPersonalizada;
    private javax.swing.JLabel CalPanLblHora;
    private javax.swing.JLabel CalPanLblMinutos;
    private javax.swing.JPanel CalPanRuta;
    private javax.swing.JSpinner CalPanSpinHora;
    private javax.swing.JSpinner CalPanSpinMinutos;
    private javax.swing.JPanel CalPanVeterinaria;
    private javax.swing.JScrollPane CalScrollActividades;
    private javax.swing.JScrollPane CalScrollInfoAct;
    private javax.swing.JSpinner CalSpinDistancia;
    private javax.swing.JTextArea CalTxtAreaInfoAct;
    private javax.swing.JTextField CalTxtNombreResp;
    private javax.swing.JTextField CalTxtTipoAlimento;
    private com.toedter.calendar.JYearChooser CalYearChooser;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JButton PerroBtnAgregar;
    private javax.swing.JButton PerroBtnEditar;
    private javax.swing.JButton PerroBtnExaminar;
    private javax.swing.JButton PerroBtnGuardar;
    private javax.swing.JComboBox<String> PerroComboPerros;
    private javax.swing.JLabel PerroLblAdvertencia;
    private javax.swing.JLabel PerroLblAltura;
    private javax.swing.JLabel PerroLblComentarios;
    private javax.swing.JLabel PerroLblFoto;
    private javax.swing.JLabel PerroLblFotoBoton;
    private javax.swing.JLabel PerroLblNombre;
    private javax.swing.JLabel PerroLblPerros;
    private javax.swing.JLabel PerroLblPeso;
    private javax.swing.JPanel PerroPanFoto;
    private javax.swing.JPanel PerroPanInformacion;
    private javax.swing.JSpinner PerroSpinAltura;
    private javax.swing.JSpinner PerroSpinPeso;
    private javax.swing.JTextField PerroTxtComentarios;
    private javax.swing.JTextField PerroTxtNombre;
    private javax.swing.JButton UsuarioBtnAgregar;
    private javax.swing.JComboBox<String> UsuarioComboUsuarios;
    private javax.swing.JLabel UsuarioLblActividad;
    private javax.swing.JLabel UsuarioLblActividades;
    private javax.swing.JLabel UsuarioLblAdvertencia;
    private javax.swing.JLabel UsuarioLblFecha;
    private javax.swing.JLabel UsuarioLblMail;
    private javax.swing.JLabel UsuarioLblNombre;
    private javax.swing.JLabel UsuarioLblUsuarios;
    private javax.swing.JList<String> UsuarioLstActividades;
    private javax.swing.JList<String> UsuarioLstFechas;
    private javax.swing.JScrollPane UsuarioScrollActividades;
    private javax.swing.JScrollPane UsuarioScrollFechas;
    private javax.swing.JTextField UsuarioTxtMail;
    private javax.swing.JTextField UsuarioTxtNombre;
    private javax.swing.JPanel panCalendario;
    private javax.swing.JPanel panPerros;
    private javax.swing.JPanel panUsuarios;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
