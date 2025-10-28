namespace CLIESC_CONUNI_GR08.ec.edu.monster.vista
{
    partial class ConversionForm
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.panel1 = new System.Windows.Forms.Panel();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.lblTipoConversion = new System.Windows.Forms.Label();
            this.cmbTipoConversion = new System.Windows.Forms.ComboBox();
            this.lblValor = new System.Windows.Forms.Label();
            this.txtValor = new System.Windows.Forms.TextBox();
            this.lblUnidadOrigen = new System.Windows.Forms.Label();
            this.cmbUnidadOrigen = new System.Windows.Forms.ComboBox();
            this.lblUnidadDestino = new System.Windows.Forms.Label();
            this.cmbUnidadDestino = new System.Windows.Forms.ComboBox();
            this.btnIntercambiar = new System.Windows.Forms.Button();
            this.lblResultado = new System.Windows.Forms.Label();
            this.txtResultado = new System.Windows.Forms.TextBox();
            this.btnConvertir = new System.Windows.Forms.Button();
            this.btnLimpiar = new System.Windows.Forms.Button();
            this.btnVolver = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackgroundImage = global::CLIESC_CONUNI_GR08.Properties.Resources.fondo2;
            this.panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.panel1.Controls.Add(this.lblTitulo);
            this.panel1.Controls.Add(this.lblTipoConversion);
            this.panel1.Controls.Add(this.cmbTipoConversion);
            this.panel1.Controls.Add(this.lblValor);
            this.panel1.Controls.Add(this.txtValor);
            this.panel1.Controls.Add(this.lblUnidadOrigen);
            this.panel1.Controls.Add(this.cmbUnidadOrigen);
            this.panel1.Controls.Add(this.lblUnidadDestino);
            this.panel1.Controls.Add(this.cmbUnidadDestino);
            this.panel1.Controls.Add(this.btnIntercambiar);
            this.panel1.Controls.Add(this.lblResultado);
            this.panel1.Controls.Add(this.txtResultado);
            this.panel1.Controls.Add(this.btnConvertir);
            this.panel1.Controls.Add(this.btnLimpiar);
            this.panel1.Controls.Add(this.btnVolver);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(953, 554);
            this.panel1.TabIndex = 15;
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.BackColor = System.Drawing.Color.Transparent;
            this.lblTitulo.Font = new System.Drawing.Font("Showcard Gothic", 19.8F);
            this.lblTitulo.ForeColor = System.Drawing.Color.Purple;
            this.lblTitulo.Location = new System.Drawing.Point(267, 40);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(448, 43);
            this.lblTitulo.TabIndex = 0;
            this.lblTitulo.Text = "Conversión de Unidades";
            // 
            // lblTipoConversion
            // 
            this.lblTipoConversion.AutoSize = true;
            this.lblTipoConversion.BackColor = System.Drawing.Color.Transparent;
            this.lblTipoConversion.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTipoConversion.Location = new System.Drawing.Point(147, 120);
            this.lblTipoConversion.Name = "lblTipoConversion";
            this.lblTipoConversion.Size = new System.Drawing.Size(158, 20);
            this.lblTipoConversion.TabIndex = 1;
            this.lblTipoConversion.Text = "Tipo de Conversión:";
            // 
            // cmbTipoConversion
            // 
            this.cmbTipoConversion.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbTipoConversion.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbTipoConversion.FormattingEnabled = true;
            this.cmbTipoConversion.Location = new System.Drawing.Point(330, 117);
            this.cmbTipoConversion.Name = "cmbTipoConversion";
            this.cmbTipoConversion.Size = new System.Drawing.Size(274, 28);
            this.cmbTipoConversion.TabIndex = 2;
            this.cmbTipoConversion.SelectedIndexChanged += new System.EventHandler(this.cmbTipoConversion_SelectedIndexChanged);
            // 
            // lblValor
            // 
            this.lblValor.AutoSize = true;
            this.lblValor.BackColor = System.Drawing.Color.Transparent;
            this.lblValor.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblValor.Location = new System.Drawing.Point(147, 170);
            this.lblValor.Name = "lblValor";
            this.lblValor.Size = new System.Drawing.Size(53, 20);
            this.lblValor.TabIndex = 3;
            this.lblValor.Text = "Valor:";
            // 
            // txtValor
            // 
            this.txtValor.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtValor.Location = new System.Drawing.Point(330, 167);
            this.txtValor.Name = "txtValor";
            this.txtValor.Size = new System.Drawing.Size(274, 26);
            this.txtValor.TabIndex = 4;
            this.txtValor.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtValor_KeyPress);
            // 
            // lblUnidadOrigen
            // 
            this.lblUnidadOrigen.AutoSize = true;
            this.lblUnidadOrigen.BackColor = System.Drawing.Color.Transparent;
            this.lblUnidadOrigen.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblUnidadOrigen.Location = new System.Drawing.Point(147, 220);
            this.lblUnidadOrigen.Name = "lblUnidadOrigen";
            this.lblUnidadOrigen.Size = new System.Drawing.Size(144, 20);
            this.lblUnidadOrigen.TabIndex = 5;
            this.lblUnidadOrigen.Text = "Unidad de Origen:";
            // 
            // cmbUnidadOrigen
            // 
            this.cmbUnidadOrigen.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbUnidadOrigen.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbUnidadOrigen.FormattingEnabled = true;
            this.cmbUnidadOrigen.Location = new System.Drawing.Point(330, 217);
            this.cmbUnidadOrigen.Name = "cmbUnidadOrigen";
            this.cmbUnidadOrigen.Size = new System.Drawing.Size(274, 28);
            this.cmbUnidadOrigen.TabIndex = 6;
            // 
            // lblUnidadDestino
            // 
            this.lblUnidadDestino.AutoSize = true;
            this.lblUnidadDestino.BackColor = System.Drawing.Color.Transparent;
            this.lblUnidadDestino.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblUnidadDestino.Location = new System.Drawing.Point(147, 270);
            this.lblUnidadDestino.Name = "lblUnidadDestino";
            this.lblUnidadDestino.Size = new System.Drawing.Size(152, 20);
            this.lblUnidadDestino.TabIndex = 7;
            this.lblUnidadDestino.Text = "Unidad de Destino:";
            // 
            // cmbUnidadDestino
            // 
            this.cmbUnidadDestino.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbUnidadDestino.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cmbUnidadDestino.FormattingEnabled = true;
            this.cmbUnidadDestino.Location = new System.Drawing.Point(330, 267);
            this.cmbUnidadDestino.Name = "cmbUnidadDestino";
            this.cmbUnidadDestino.Size = new System.Drawing.Size(274, 28);
            this.cmbUnidadDestino.TabIndex = 8;
            // 
            // btnIntercambiar
            // 
            this.btnIntercambiar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(193)))), ((int)(((byte)(7)))));
            this.btnIntercambiar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnIntercambiar.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnIntercambiar.ForeColor = System.Drawing.Color.White;
            this.btnIntercambiar.Location = new System.Drawing.Point(620, 217);
            this.btnIntercambiar.Name = "btnIntercambiar";
            this.btnIntercambiar.Size = new System.Drawing.Size(110, 68);
            this.btnIntercambiar.TabIndex = 9;
            this.btnIntercambiar.Text = "⇄ Intercambiar";
            this.btnIntercambiar.UseVisualStyleBackColor = false;
            this.btnIntercambiar.Click += new System.EventHandler(this.btnIntercambiar_Click);
            // 
            // lblResultado
            // 
            this.lblResultado.AutoSize = true;
            this.lblResultado.BackColor = System.Drawing.Color.Transparent;
            this.lblResultado.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblResultado.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(40)))), ((int)(((byte)(167)))), ((int)(((byte)(69)))));
            this.lblResultado.Location = new System.Drawing.Point(147, 330);
            this.lblResultado.Name = "lblResultado";
            this.lblResultado.Size = new System.Drawing.Size(0, 25);
            this.lblResultado.TabIndex = 10;
            // 
            // txtResultado
            // 
            this.txtResultado.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtResultado.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(40)))), ((int)(((byte)(167)))), ((int)(((byte)(69)))));
            this.txtResultado.Location = new System.Drawing.Point(330, 330);
            this.txtResultado.Name = "txtResultado";
            this.txtResultado.ReadOnly = true;
            this.txtResultado.Size = new System.Drawing.Size(274, 30);
            this.txtResultado.TabIndex = 11;
            // 
            // btnConvertir
            // 
            this.btnConvertir.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(122)))), ((int)(((byte)(204)))));
            this.btnConvertir.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnConvertir.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnConvertir.ForeColor = System.Drawing.Color.White;
            this.btnConvertir.Location = new System.Drawing.Point(330, 400);
            this.btnConvertir.Name = "btnConvertir";
            this.btnConvertir.Size = new System.Drawing.Size(120, 45);
            this.btnConvertir.TabIndex = 12;
            this.btnConvertir.Text = "Convertir";
            this.btnConvertir.UseVisualStyleBackColor = false;
            this.btnConvertir.Click += new System.EventHandler(this.btnConvertir_Click);
            // 
            // btnLimpiar
            // 
            this.btnLimpiar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(193)))), ((int)(((byte)(7)))));
            this.btnLimpiar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLimpiar.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnLimpiar.ForeColor = System.Drawing.Color.White;
            this.btnLimpiar.Location = new System.Drawing.Point(470, 400);
            this.btnLimpiar.Name = "btnLimpiar";
            this.btnLimpiar.Size = new System.Drawing.Size(120, 45);
            this.btnLimpiar.TabIndex = 13;
            this.btnLimpiar.Text = "Limpiar";
            this.btnLimpiar.UseVisualStyleBackColor = false;
            this.btnLimpiar.Click += new System.EventHandler(this.btnLimpiar_Click);
            // 
            // btnVolver
            // 
            this.btnVolver.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(53)))), ((int)(((byte)(69)))));
            this.btnVolver.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnVolver.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVolver.ForeColor = System.Drawing.Color.White;
            this.btnVolver.Location = new System.Drawing.Point(610, 400);
            this.btnVolver.Name = "btnVolver";
            this.btnVolver.Size = new System.Drawing.Size(120, 45);
            this.btnVolver.TabIndex = 14;
            this.btnVolver.Text = "Volver";
            this.btnVolver.UseVisualStyleBackColor = false;
            this.btnVolver.Click += new System.EventHandler(this.btnVolver_Click);
            // 
            // ConversionForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(953, 554);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "ConversionForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Conversión de Unidades";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Label lblTipoConversion;
        private System.Windows.Forms.ComboBox cmbTipoConversion;
        private System.Windows.Forms.Label lblValor;
        private System.Windows.Forms.TextBox txtValor;
        private System.Windows.Forms.Label lblUnidadOrigen;
        private System.Windows.Forms.ComboBox cmbUnidadOrigen;
        private System.Windows.Forms.Label lblUnidadDestino;
        private System.Windows.Forms.ComboBox cmbUnidadDestino;
        private System.Windows.Forms.Button btnIntercambiar;
        private System.Windows.Forms.Label lblResultado;
        private System.Windows.Forms.TextBox txtResultado;
        private System.Windows.Forms.Button btnConvertir;
        private System.Windows.Forms.Button btnLimpiar;
        private System.Windows.Forms.Button btnVolver;
        private System.Windows.Forms.Panel panel1;
    }
}
