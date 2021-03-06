package githubusersearch;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.json.JSONException;

/**
 *
 * @author William
 */
public class UserPanel implements MouseListener{
    User user;
    
    JPanel userPanel = new JPanel();

    JLabel userImage = new JLabel("");
    JButton username = new JButton("");
    JLabel description = new JLabel("");
    
    /**
     *
     * @param user
     */
    public UserPanel(User user){
        this.user = user;
        
        username.setText(user.getLogin());
        userImage.setIcon(user.getUserImageIcon());
        //description.setText();
        
        
        userPanel.setLayout(new GridBagLayout());
        //userPanel.setMaximumSize(new Dimension(300,300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        //userPanel.add(Box.createVerticalGlue(),gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        userPanel.add(userImage, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        
        username.setForeground(Color.BLACK);
        username.setOpaque(false);
        username.setContentAreaFilled(false);
        username.setBorderPainted(false);
        username.addMouseListener(this);
        userPanel.add(username, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        userPanel.add(description, gbc);
        userPanel.setBackground(Color.WHITE);
    }
    
    /**
     *
     * @return
     */
    protected JPanel getUserPanel(){
            return userPanel;
    }
    
    // Setter

    /**
     *
     * @param userImageIcon
     */
    protected void setUserImage(ImageIcon userImageIcon){
        userImage.setIcon(userImageIcon);
    }
    
    // Getter

    /**
     *
     * @return
     */
    protected ImageIcon getUserImage(){
        return (ImageIcon) userImage.getIcon();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Controller.showUserRepos(user.getReposURL());
        } catch (IOException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        username.setForeground(Color.BLUE);
        username.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        username.setForeground(Color.BLACK);
        username.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
