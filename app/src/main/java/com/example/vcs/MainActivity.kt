package com.example.vcs

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.example.vcs.ui.theme.VersioncatalogsampleTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VersioncatalogsampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main(
                        onAddClick = {
                            // 時間のみ
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ISO_TIME
                            val formatted = current.format(formatter)

                            val shortcut = ShortcutInfoCompat.Builder(applicationContext, formatted)
                                .setShortLabel(formatted)
                                .setIcon(IconCompat.createWithResource(applicationContext, R.drawable.ic_launcher_foreground))
                                .setIntent(Intent.makeMainActivity(ComponentName(applicationContext, "com.example.vcs.MainActivity")))
                                .build()
                            ShortcutManagerCompat.pushDynamicShortcut(applicationContext, shortcut)
                        },
                        onRemoveClick = {
                            ShortcutManagerCompat.removeAllDynamicShortcuts(applicationContext)
                        })
                }
            }
        }
    }
}

@Composable
fun Main(
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit
) {
    Column {
        Greeting("Android")
        AddShortCut(onClick = onAddClick)
        RemoveShortCut(onClick = onRemoveClick)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun AddShortCut(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "ショートカット追加")
    }
}

@Composable
fun RemoveShortCut(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "ショートカット削除")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VersioncatalogsampleTheme {
        Main(onAddClick = {}, onRemoveClick = {})
    }
}