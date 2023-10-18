package Hello;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements KeyListener{// ̳и    ˽ з        㴴   µķ

    int[][] datas = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };

    int fx = datas.length - 1, fy = datas.length - 1;

    //
    public MainFrame(){
        initFrame();
        pantview();
        //
        this.addKeyListener(this);
        setVisible(true);//   ô   ɼ
    }

    //     ʼ
    public void initFrame(){
        setTitle("  Ϸ");
        setSize(804, 534);//   óߴ
        setLocationRelativeTo(null);//   ô
        setAlwaysOnTop(true);//   ô    ö
        setDefaultCloseOperation(3);//   ô   Ĺر ģʽ
        //ȡ      Ĭ ϲ
        setLayout(null);
    }

    //ͼƬ  ӳ
    public void pantview(){

        /*   Ƴ   ԭ еĻ   */
        getContentPane().removeAll();

        for(int i = 0; i < 3; i ++)
            for(int j = 0; j < 3; j ++) {
                JLabel image = new JLabel(new ImageIcon("C:\\Users\\22349\\Pictures\\Camera Roll\\" + datas[i][j] + ".png"));//  ȡͼƬ
                image.setBounds(100 + 202 * j, 100 + 112 * i, 200, 110);
                getContentPane().add(image);//  ͼƬ   봰
            }
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\22349\\Pictures\\Camera Roll\\刘子涵.jpg"));//   뱳
        background.setBounds(100, 100, 604, 334);
        //  ŵ ͼƬ
        getContentPane().add(background);

        getContentPane().repaint();//ˢ ½
    }

    @Override
    public void keyTyped(KeyEvent e) {}// ϶ఴ     Ӳ

    @Override
    /*          */
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int keycode = e.getKeyCode();
        if(keycode == 87) {//
            MoveUp();
        }else if(keycode == 83) {//
            MoveDown();
        }else if(keycode == 65) {//
            MoveLeft();
        }else if(keycode == 68) {//
            MoveRight();
        }
    }


    @Override
    /*     ɿ */
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void MoveLeft() {
        // TODO Auto-generated method stub
        if(fy + 1 >= 0 && fy + 1 < datas.length) {
            swap(fx, fy, fx, fy + 1);
            pantview();//   »  ƽ
        }

    }

    public void MoveRight() {
        // TODO Auto-generated method stub
        if(fy - 1 >= 0 && fy - 1 < datas.length) {
            swap(fx, fy, fx, fy - 1);
            pantview();//   »  ƽ
        }
    }

    public void MoveDown(){
        // TODO Auto-generated method stub

        if(fx - 1 >= 0 && fx - 1 < datas.length) {
            swap(fx, fy, fx - 1, fy);
            pantview();//   »  ƽ
        }
    }

    public void MoveUp() {
        // TODO Auto-generated method stub
        if(fx + 1 >= 0 && fx + 1 < datas.length) {
            swap(fx, fy, fx + 1, fy);
            pantview();//   »  ƽ
        }
    }

    public void swap(int xx, int yy, int x, int y) {
        int temp = datas[xx][yy];
        datas[xx][yy] = datas[x][y];
        datas[x][y] = temp;
        fx = x;
        fy = y;
    }
}
