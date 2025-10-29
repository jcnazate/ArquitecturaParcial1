using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CLIESC_CONUNI_GR08.ec.edu.monster.controlador;
using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.vista
{
    public partial class LoginForm : Form
    {
        private LoginController _loginController;
        private LoginModel _loginModel;

        public LoginForm()
        {
            InitializeComponent();
            _loginController = new LoginController();
            _loginModel = new LoginModel();
        }

        private async void btnLogin_Click(object sender, EventArgs e)
        {
            try
            {
                string username = txtUsername.Text.Trim();
                string password = txtPassword.Text.Trim();

                if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
                {
                    MessageBox.Show("Por favor ingrese usuario y contraseña.", "Error", 
                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                // Mostrar indicador de carga
                btnLogin.Enabled = false;
                btnLogin.Text = "Validando...";

                // Validar credenciales
                bool esValido = await ValidarCredencialesConTimeout(username, password);

                if (esValido)
                {
                    MessageBox.Show("¡Login exitoso!", "Éxito", 
                        MessageBoxButtons.OK, MessageBoxIcon.Information);
                    
                    // Abrir formulario principal
                    this.Hide();
                    var mainForm = new MainForm();
                    mainForm.ShowDialog();
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Usuario o contraseña incorrectos.", "Error de Login", 
                        MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al realizar login: {ex.Message}", "Error", 
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                // Restaurar botón
                btnLogin.Enabled = true;
                btnLogin.Text = "Iniciar Sesión";
            }
        }

        private async Task<bool> ValidarCredencialesConTimeout(string username, string password)
        {
            try
            {
                // Crear una tarea con timeout de 10 segundos
                var timeoutTask = Task.Delay(10000); // 10 segundos
                var loginTask = _loginController.ValidarCredencialesAsync(username, password);

                var completedTask = await Task.WhenAny(loginTask, timeoutTask);

                if (completedTask == timeoutTask)
                {
                    MessageBox.Show("Timeout: El servicio no respondió en 10 segundos. Verifique que el servicio REST esté ejecutándose.", "Error de Conexión",
                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return false;
                }

                return await loginTask;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error de conexión: {ex.Message}\n\nVerifique que el servicio REST esté ejecutándose en http://localhost:5000", "Error de Conexión",
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
        }
        private void btnCancel_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void txtPassword_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                btnLogin_Click(sender, e);
            }
        }

        private void txtUsername_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                txtPassword.Focus();
            }
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void lblTitle_Click(object sender, EventArgs e)
        {

        }

        private void LoginForm_Load(object sender, EventArgs e)
        {

        }
    }
}
