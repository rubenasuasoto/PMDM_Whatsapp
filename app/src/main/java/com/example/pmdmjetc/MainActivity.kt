package com.example.pmdmjetc
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pmdmjetc.navegacion.AppScreen
import com.example.pmdmjetc.navegacion.Whatsapp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Whatsapp()
        }
    }
}

val mainColor = Color.Black


val lastMessageTimes = listOf(
    "10:45 AM", "Yesterday", "8:23 PM", "11:10 AM", "Saturday",
    "9:30 AM", "Today", "5:15 PM", "1:20 PM", "Sunday"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = mainColor, titleContentColor = Color.White),
        title = { Text(text = stringResource(id = R.string.app_name), fontWeight = FontWeight.Bold, fontSize = 20.sp) },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Call, contentDescription = stringResource(id = R.string.calls), tint = Color.White)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Search, contentDescription = stringResource(id = R.string.search), tint = Color.White)
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = stringResource(id = R.string.options), tint = Color.White)
            }
        }
    )
}

@Composable
fun WhatsAppMenuScreen(navController: NavHostController) {
    val contactNames = listOf(
        stringResource(id = R.string.contact_pablo),
        stringResource(id = R.string.contact_ana),
        stringResource(id = R.string.contact_carlos),
        stringResource(id = R.string.contact_marcos),
        stringResource(id = R.string.contact_laura),
        stringResource(id = R.string.contact_fernando),
        stringResource(id = R.string.contact_susana),
        stringResource(id = R.string.contact_julia),
        stringResource(id = R.string.contact_ignacio),
        stringResource(id = R.string.contact_maria)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        WhatsAppTopBar()

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color.Black)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            itemsIndexed(contactNames) { index, contactName ->
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(16.dp)
                        .clickable {
                            navController.navigate(route = AppScreen.chatScreen.route + "/$contactName")
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.Gray, shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = contactName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Last message preview...", // Placeholder
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    Text(
                        text = lastMessageTimes[index],
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        WhatsAppBottomBar()
    }
}


@Composable
fun WhatsAppBottomBar() {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = stringResource(id = R.string.home), tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = stringResource(id = R.string.message), tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = stringResource(id = R.string.cuentas), tint = Color.White)
        }
    }
}

