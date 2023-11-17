@file:OptIn(ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class)
package com.example.ucp2_155

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2_155.data.FormUiState

enum class PengelolaHalaman {
    Home,
    Summary,
    Formulir
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
) {

    TopAppBar(
        title = { Text (stringResource (id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors (
            containerColor =
            MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription =
                        stringResource(R.string.btn_back)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirApp(
    viewModel: FormUiState = viewModel(),
    navController: NavController = rememberNavController()
) {
    Scaffold(
        topBar = {
            FormulirAppBar(
                bisaNavigasiBack = false,
                navigasiUp = { /* TODO: implement back navigation */
                }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController as NavHostController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Formulir.name)
                    })
            }
            composable(route = PengelolaHalaman.Formulir.name) {
                HalamanForm(onSubmitButtonClick = {
                    viewModel.setContact(it)
                    navController.navigate(PengelolaHalaman.Summary.name)
                },
                    onNextButtonClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}


private fun cancelOrderAndNavigateToHome (
    viewModel: FormUiState,
    navController: NavController
){
    viewModel.resetOrder()
    navController.popBackStack (PengelolaHalaman.Home.name, inclusive = false)
}
private fun cancelOrderAndNavigateToRasa (
    navController: NavController
) {
    navController.popBackStack(PengelolaHalaman.Formulir.name, inclusive = false)
}

