package com.example.appteste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column//importa coluna
import androidx.compose.foundation.Image//importa imagem
import androidx.compose.foundation.layout.Row//importa linha
import androidx.compose.ui.res.painterResource//importa o resource que busca a imagem
import androidx.compose.foundation.layout.Spacer//importa o espaço
import androidx.compose.foundation.layout.height//importa altura
import androidx.compose.foundation.layout.padding//importa padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape//importa o arredondamento da imagem
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.appteste.ui.theme.AppTesteTheme
import androidx.compose.foundation.border
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.MaterialTheme


//para fazer alguma interação no design da página, é necessário importar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTesteTheme() {//o método é contruido no início do projeto. Ele leva o nome do projeto e o Theme
                //o caminho do diretório é Deisgn/appteste//ui.theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Android", "Jetpack Compose"))
                    //puxa um método com determinados parametros
                    // analogia com divs
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
//a partir de uma classe, ele criará as variáveis correspondentes

@Composable
fun MessageCard(msg: Message) {//função já com atributos declarado
    //fun MessageCard(author: String, body: String) --> forma de sobescrever

    //adiciona um padding em toda sua mensagem
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.foto),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set imagem size 40dp
                .size(40.dp)
                // Clip imagem circular
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)

        )

        // adiciona um espaço entre a imagem e o texto
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // adiciona um espaço entre os dois textos
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    AppTesteTheme() {
        Surface {
            MessageCard(
                msg = Message("Lexi", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}
