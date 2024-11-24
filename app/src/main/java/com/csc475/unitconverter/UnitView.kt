package com.csc475.unitconverter

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UnitView(viewModel: UnitViewModel) {
    var input by remember { mutableStateOf("") }
    var selectedConversion by remember { mutableStateOf(UnitViewModel.ConversionType.C_TO_F) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Input TextField
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Enter value") },
            modifier = Modifier.fillMaxWidth()
        )

        // Dropdown for selecting units
        DropdownMenuWrapper(
            selectedConversion = selectedConversion,
            onConversionSelected = { newSelection ->
                selectedConversion = newSelection
            }
        )

        // Button to perform conversion
        Button(
            onClick = {
                viewModel.inputText = input
                viewModel.conversionType = selectedConversion
                viewModel.performConversion()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convert")
        }

        // Result display
        val result = viewModel.result.observeAsState()
        Text(
            text = "Result: ${result.value ?: "No result"}",
            style = MaterialTheme.typography.headlineSmall
        )

        // Error display
        val error = viewModel.error.observeAsState()
        if (error.value != null) {
            Text(error.value!!, color = MaterialTheme.colorScheme.error)
        }
    }
}

@Composable
fun DropdownMenuWrapper(
    selectedConversion: UnitViewModel.ConversionType,
    onConversionSelected: (UnitViewModel.ConversionType) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        // Button to toggle dropdown menu
        Button(onClick = { expanded = true }) {
            Text(text = selectedConversion.name.replace("_", " "))
        }

        // Dropdown menu items
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            UnitViewModel.ConversionType.entries.forEach { conversion ->
                DropdownMenuItem(
                    text = {
                        Text(conversion.name.replace("_", " "))
                    },
                    onClick = {
                        onConversionSelected(conversion)
                        expanded = false
                    }
                )
            }
        }
    }
}
