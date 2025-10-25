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
    public partial class ConversionForm : Form
    {
        private ConversionController _conversionController;
        private ConversionModel _conversionModel;

        public ConversionForm()
        {
            InitializeComponent();
            _conversionController = new ConversionController();
            _conversionModel = new ConversionModel();
            InitializeComboBoxes();
        }

        private void InitializeComboBoxes()
        {
            // Inicializar combo de tipo de conversión
            cmbTipoConversion.Items.Add("LONGITUD");
            cmbTipoConversion.Items.Add("TEMPERATURA");
            cmbTipoConversion.Items.Add("MASA");
            cmbTipoConversion.SelectedIndex = 0;

            // Inicializar combos de unidades
            UpdateUnitComboBoxes();
        }

        private void UpdateUnitComboBoxes()
        {
            cmbUnidadOrigen.Items.Clear();
            cmbUnidadDestino.Items.Clear();

            string tipoConversion = cmbTipoConversion.SelectedItem?.ToString();

            switch (tipoConversion)
            {
                case "LONGITUD":
                    cmbUnidadOrigen.Items.AddRange(new string[] { "PULGADAS", "CENTIMETROS" });
                    cmbUnidadDestino.Items.AddRange(new string[] { "PULGADAS", "CENTIMETROS" });
                    break;
                case "TEMPERATURA":
                    cmbUnidadOrigen.Items.AddRange(new string[] { "CELSIUS", "KELVIN" });
                    cmbUnidadDestino.Items.AddRange(new string[] { "CELSIUS", "KELVIN" });
                    break;
                case "MASA":
                    cmbUnidadOrigen.Items.AddRange(new string[] { "GRAMOS", "KILOGRAMOS" });
                    cmbUnidadDestino.Items.AddRange(new string[] { "GRAMOS", "KILOGRAMOS" });
                    break;
            }

            if (cmbUnidadOrigen.Items.Count > 0)
                cmbUnidadOrigen.SelectedIndex = 0;
            if (cmbUnidadDestino.Items.Count > 1)
                cmbUnidadDestino.SelectedIndex = 1;
        }

        private void cmbTipoConversion_SelectedIndexChanged(object sender, EventArgs e)
        {
            UpdateUnitComboBoxes();
        }

        private void btnConvertir_Click(object sender, EventArgs e)
        {
            try
            {
                // Validar entrada
                if (!double.TryParse(txtValor.Text, out double valor))
                {
                    MessageBox.Show("Por favor ingrese un valor numérico válido.", "Error", 
                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                if (cmbTipoConversion.SelectedItem == null || 
                    cmbUnidadOrigen.SelectedItem == null || 
                    cmbUnidadDestino.SelectedItem == null)
                {
                    MessageBox.Show("Por favor seleccione todos los campos.", "Error", 
                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                if (cmbUnidadOrigen.SelectedItem.ToString() == cmbUnidadDestino.SelectedItem.ToString())
                {
                    MessageBox.Show("Las unidades de origen y destino deben ser diferentes.", "Error", 
                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                // Mostrar indicador de carga
                btnConvertir.Enabled = false;
                btnConvertir.Text = "Convirtiendo...";

                // Crear modelo de conversión
                _conversionModel = new ConversionModel
                {
                    Value = valor,
                    FromUnit = cmbUnidadOrigen.SelectedItem.ToString(),
                    ToUnit = cmbUnidadDestino.SelectedItem.ToString(),
                    Result = 0.0
                };

                // Realizar conversión
                string tipoConversion = cmbTipoConversion.SelectedItem.ToString();
                _conversionModel = _conversionController.RealizarConversion(_conversionModel, tipoConversion);

                // Mostrar resultado
                txtResultado.Text = _conversionModel.Result.ToString("F4");
                lblResultado.Text = $"{_conversionModel.Value} {_conversionModel.FromUnit} = {_conversionModel.Result:F4} {_conversionModel.ToUnit}";
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al realizar la conversión: {ex.Message}", "Error", 
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                // Restaurar botón
                btnConvertir.Enabled = true;
                btnConvertir.Text = "Convertir";
            }
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            txtValor.Clear();
            txtResultado.Clear();
            lblResultado.Text = "";
            cmbTipoConversion.SelectedIndex = 0;
            UpdateUnitComboBoxes();
        }

        private void btnIntercambiar_Click(object sender, EventArgs e)
        {
            if (cmbUnidadOrigen.SelectedItem != null && cmbUnidadDestino.SelectedItem != null)
            {
                string temp = cmbUnidadOrigen.SelectedItem.ToString();
                cmbUnidadOrigen.SelectedItem = cmbUnidadDestino.SelectedItem;
                cmbUnidadDestino.SelectedItem = temp;
            }
        }

        private void txtValor_KeyPress(object sender, KeyPressEventArgs e)
        {
            // Permitir solo números, punto decimal y tecla de retroceso
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && e.KeyChar != '.')
            {
                e.Handled = true;
            }

            // Permitir solo un punto decimal
            if (e.KeyChar == '.' && (sender as TextBox).Text.IndexOf('.') > -1)
            {
                e.Handled = true;
            }

            if (e.KeyChar == (char)Keys.Enter)
            {
                btnConvertir_Click(sender, e);
            }
        }

        private void btnVolver_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
