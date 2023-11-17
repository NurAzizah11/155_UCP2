package com.example.ucp2_155

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    pilihanDospem: List<String>,
    onSelectChanged: (String) -> Unit,
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var NamaMahasiswaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var NIMTxt by rememberSaveable {
        mutableStateOf("")
    }
    var KonsentrasiTxt by rememberSaveable {
        mutableStateOf("")
    }
    var JudulSkripsiTxt by rememberSaveable {
        mutableStateOf("")
    }
    var pilihanDospem1 by rememberSaveable {
        mutableStateOf("")
    }
    var pilihanDospem2 by rememberSaveable {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(NamaMahasiswaTxt, NIMTxt, KonsentrasiTxt, JudulSkripsiTxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi", fontWeight = FontWeight.Bold, fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = NamaMahasiswaTxt,
            onValueChange = { NamaMahasiswaTxt = it },
            label = { Text(text = "Nama Mahasiswa") })

        OutlinedTextField(
            value = NIMTxt,
            onValueChange = { NIMTxt = it },
            label = { Text(text = "NIM") })

        OutlinedTextField(
            value = KonsentrasiTxt,
            onValueChange = { KonsentrasiTxt = it },
            label = { Text(text = "Konsentrasi") })

        OutlinedTextField(
            value = JudulSkripsiTxt,
            onValueChange = { JudulSkripsiTxt = it },
            label = { Text(text = "Judul Skripsi") })
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.padding(16.dp))

            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
                    pilihanDospem1.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = pilihanDospem1 == item,
                                onClick = {
                                    pilihanDospem1 = item
                                    onSelectChanged(item)
                                }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(selected = pilihanDospem1 == item,
                                onClick = {
                                    pilihanDospem1 = item
                                    onSelectChanged(item) }
                            )
                            Text(item)
                        }
                    }
                    Divider(
                        thickness = dimensionResource(R.dimen.thickness_divider),
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
                    )
        }
    }
}