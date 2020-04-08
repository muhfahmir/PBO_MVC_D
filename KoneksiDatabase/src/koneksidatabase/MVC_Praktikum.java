package koneksidatabase;

public class MVC_Praktikum {
    //untuk menghubungkan 3 kelas view model dan controller
    ViewPraktikum viewPraktikum = new ViewPraktikum();
    ModelPraktikum modelPraktikum = new ModelPraktikum();
    ControllerPraktikum controllerPraktikum = new ControllerPraktikum(modelPraktikum, viewPraktikum);
}