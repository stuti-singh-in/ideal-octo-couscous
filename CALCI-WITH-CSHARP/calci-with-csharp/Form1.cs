using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace calci_with_csharp
{
    public partial class CalculatorForm : Form
    {
        #region variables 
        // as I said simple calculator only support these operations
        string[] _operatorList = new string[] { "+", "-", "/", "*" };

        // reservednumber1 is before operator entered, 2 will be set after = 
        double? _reservedNumber1 = null, _reservedNumber2 = null;

        // I need to know which operator selected 

        string _operator = null;
        // as you see after calculation it continue to keep previous value in textbox . we want to clear after  = 

        bool _clearText = false;
        #endregion  
        public CalculatorForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // all buttons will be taken care of, here.
            var text = ((Button)sender).Text;

            textInput.Text += text;

            //if the button is an operator we need to  store first value

            var isOperator = _operatorList.Any(p => p == text);
            if(isOperator)
            {
                if(double.TryParse(textInput.Text, out double temp))
                {
                    _reservedNumber1 = temp;
                    textInput.Clear();
                    lblResult.Text = $"{_reservedNumber1} {text}";
                    _operator = text;
                }
            }
            else
            if(text == "=")
            {
                if(double.TryParse(textInput.Text, out double temp))
                {
                    _reservedNumber2 = temp;
                }
                Calculate();
                _clearText = false;
            }
            else
            {
                if (_clearText)
                {
                    textInput.Text = text;
                    // only once will be cleared then rest will be the same flow.
                    _clearText = false;
                }
                else
                {
                    textInput.Text += text;
                }
            }
        }

        private void Calculate()
        {
            double? result = 0;
            switch (_operator)
            {
                case "+":
                    result = _reservedNumber2 + _reservedNumber1;
                    break;
                case "/":
                    result = _reservedNumber1 / _reservedNumber2;
                    break;
                case "-":
                    result = _reservedNumber1 - _reservedNumber2;
                    break;
                case "*":
                    result = _reservedNumber2 * _reservedNumber1;
                    break;
                default:
                    break;
            }
            lblResult.Text = result.ToString();
        }


    private void button16_Click(object sender, EventArgs e)
        {
            textInput.Clear();
        lblResult.Text = String.Empty;
        }
    }
}
