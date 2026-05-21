package com.example.studyfocustimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyfocustimer.ui.theme.StudyFocusTimerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyFocusTimerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudyFocusTimerApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StudyFocusTimerApp(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("main") }
    var focusDuration by remember { mutableIntStateOf(25) }
    var breakDuration by remember { mutableIntStateOf(5) }
    var showMotivationalMessage by remember { mutableStateOf(true) }
    var isFocusing by remember { mutableStateOf(false) }

    if (currentScreen == "main") {
        MainScreen(
            focusDuration = focusDuration,
            breakDuration = breakDuration,
            showMotivationalMessage = showMotivationalMessage,
            isFocusing = isFocusing,
            onStartClick = { isFocusing = true },
            onResetClick = { isFocusing = false },
            onSettingsClick = { currentScreen = "settings" },
            modifier = modifier
        )
    } else {
        SettingsScreen(
            focusDuration = focusDuration,
            breakDuration = breakDuration,
            showMotivationalMessage = showMotivationalMessage,
            onFocusDurationChange = { focusDuration = it },
            onBreakDurationChange = { breakDuration = it },
            onMotivationalMessageChange = { showMotivationalMessage = it },
            onBackClick = { currentScreen = "main" },
            modifier = modifier
        )
    }
}

@Composable
fun MainScreen(
    focusDuration: Int,
    breakDuration: Int,
    showMotivationalMessage: Boolean,
    isFocusing: Boolean,
    onStartClick: () -> Unit,
    onResetClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Study Focus Timer",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$focusDuration minutes",
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = if (isFocusing) "Focusing" else "Ready to focus",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Break duration: $breakDuration minutes",
                    fontSize = 16.sp
                )

                if (showMotivationalMessage) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Stay focused. One task at a time.",
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = onStartClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(if (isFocusing) "Focusing" else "Start")
            }

            OutlinedButton(
                onClick = onResetClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onSettingsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Settings")
        }
    }
}

@Composable
fun SettingsScreen(
    focusDuration: Int,
    breakDuration: Int,
    showMotivationalMessage: Boolean,
    onFocusDurationChange: (Int) -> Unit,
    onBreakDurationChange: (Int) -> Unit,
    onMotivationalMessageChange: (Boolean) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Settings",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Focus Duration",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(15, 25, 45).forEach { duration ->
                FilterChip(
                    selected = focusDuration == duration,
                    onClick = { onFocusDurationChange(duration) },
                    label = { Text("$duration min") }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Break Duration",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(5, 10, 15).forEach { duration ->
                FilterChip(
                    selected = breakDuration == duration,
                    onClick = { onBreakDurationChange(duration) },
                    label = { Text("$duration min") }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Show motivational message",
                fontSize = 18.sp
            )

            Switch(
                checked = showMotivationalMessage,
                onCheckedChange = onMotivationalMessageChange
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Timer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    StudyFocusTimerTheme {
        MainScreen(
            focusDuration = 25,
            breakDuration = 5,
            showMotivationalMessage = true,
            isFocusing = false,
            onStartClick = {},
            onResetClick = {},
            onSettingsClick = {}
        )
    }
}