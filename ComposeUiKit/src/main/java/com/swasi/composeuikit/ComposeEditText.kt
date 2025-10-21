package com.swasi.composeuikit

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    editTextHint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(editTextHint)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone,
            onNext = onNext
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        singleLine = true
    )
}

@Preview
@Composable
fun AppTextFieldPreview1() {
    AppTextField(
        modifier = Modifier.fillMaxWidth(),
        editTextHint = "Hello", onTextChanged = {

        })
}

@Composable
fun AppTextFieldWithIcon(
    modifier: Modifier = Modifier,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(hint)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone,
            onNext = onNext
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}


@Composable
fun ComposeOutLinedTextField(
    modifier: Modifier = Modifier,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(hint)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone,
            onNext = onNext
        ),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@Preview
@Composable
fun AppOutLinedTextFieldPreview1() {
    ComposeOutLinedTextField(hint = "Hello", onTextChanged = {

    })
}

@Composable
fun ComposeOutLinedTextFieldWithIcon(
    modifier: Modifier = Modifier,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onTextChanged: (String) -> Unit,
    onNext: ((KeyboardActionScope) -> Unit)? = null,
    onDone: ((KeyboardActionScope) -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: ImageVector = Icons.Default.Email,
    iconColor: Color = Color.Black
) {

    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            Text(hint)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone,
            onNext = onNext
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        leadingIcon = {
            Icon(
                imageVector = icon, contentDescription = text,
                tint = iconColor
            )
        }
    )
}

@Preview
@Composable
fun AppTextFieldPreview() {
    AppTextField(editTextHint = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppTextFieldWithIconPreview() {
    AppTextFieldWithIcon(hint = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldPreview() {
    ComposeOutLinedTextField(hint = "", onTextChanged = {

    })
}

@Preview
@Composable
fun AppOutLinedTextFieldWithIconPreview() {
    ComposeOutLinedTextFieldWithIcon(hint = "", onTextChanged = {

    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@Preview
@Composable
fun TextFieldWithInputTypePreview() {
    TextFieldWithInputType()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}

@Preview
@Composable
fun OutLineTextFieldPreview() {
    OutLineTextField()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}

@Preview
@Composable
fun TextFieldWithIconsPreview() {
    TextFieldWithIcons()
}

@Composable
fun AppEditTextMain(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: androidx.compose.ui.graphics.Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors()
) {
    var text by remember { mutableStateOf(TextFieldValue(value.text)) }
    TextField(
        value = text,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        onValueChange = { it ->
            text = it
            onValueChange(it)
        }
    )
}

@Preview
@Composable
fun AppEditTextMainPreview() {
    AppEditTextMain(value = TextFieldValue(""), onValueChange = {
        Log.i("TAG", "AppEditTextMainPreview: $it")
    })
}