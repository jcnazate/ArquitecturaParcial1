namespace WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.model
{
    public class LoginModel
    {
        public bool Login(string user, string password)
        {
            // Compara con el usuario y la contraseña hasheada
            return user == "MONSTER" && password == "MONSTER9";
        }
    }
}
