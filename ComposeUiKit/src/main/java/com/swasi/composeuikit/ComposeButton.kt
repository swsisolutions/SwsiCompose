package com.swasi.composeuikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeuikit.theme.Colors

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Compose Button",
    buttonColor: Color = Colors.teal700,
    buttonTextColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(radios.dp),
    isEnabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8,
    defaultElevation: Int = 0,
    pressedElevation: Int = 0,
    disabledElevation: Int = 0
) {
    Button(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = shape,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonTextColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = defaultElevation.dp,
            pressedElevation = pressedElevation.dp,
            disabledElevation = disabledElevation.dp
        )
    ) {
        Text(color = buttonTextColor, text = buttonText)
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    AppButton(onClick = {})
}

@Composable
fun AppButtonDisable(
    modifier: Modifier = Modifier,
    buttonText: String = "App Button Disabled",
    buttonColor: Color = Color.Gray,
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8,
    isEnabled: Boolean = true
) {

    Button(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(radios.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor
        )
    ) {
        Text(color = textColor, text = buttonText)
    }
}

@Preview
@Composable
fun AppButtonDisablePreview() {
    AppButtonDisable(buttonText = "Cancel", onClick = {})
}

@Composable
fun AppErrorButtonDisable(
    modifier: Modifier = Modifier,
    title: String = "Error",
    buttonColor: Color = Color.Red,
    textColor: Color = Color.White,
    onClick: (() -> Unit),
    radios: Int = 8
) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .then(modifier)
    ) {
        Text(color = textColor, text = title)
    }
}

@Preview
@Composable
fun AppButtonErrorPreview() {
    AppErrorButtonDisable(title = "Cancel", onClick = {})
}

@Composable
fun AppButtonWithIcon(
    modifier: Modifier = Modifier,
    buttonText: String = "App Button with Icon",
    buttonColor: Color = Colors.teal700,
    buttonTextColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8,
    iconDrawable: Int,
    iconContentDesc: String = "content description",
    isTextAtStart: Boolean? = true // if null, only icon will be shown
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(radios.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonTextColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .then(modifier)
    ) {
        when {
            isTextAtStart == null -> {
                Image(
                    painterResource(id = iconDrawable),
                    contentDescription = iconContentDesc,
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(buttonTextColor)
                )
            }

            isTextAtStart -> {
                Text(color = buttonTextColor, text = buttonText)
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Image(
                    painterResource(id = iconDrawable),
                    contentDescription = iconContentDesc,
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(buttonTextColor)
                )
            }

            !isTextAtStart -> {
                Image(
                    painterResource(id = iconDrawable),
                    contentDescription = iconContentDesc,
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(buttonTextColor)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(color = buttonTextColor, text = buttonText)
            }

            else -> {}
        }
    }
}

@Preview
@Composable
fun AppButtonIconPreview() {
    AppButtonWithIcon(
        buttonText = "AppButton with Icon",
        onClick = {},
        iconDrawable = R.drawable.ic_rabit,
        isTextAtStart = null
    )
}


@Composable
fun AppOutlinedButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Compose Button",
    buttonColor: Color = Colors.teal700,
    buttonTextColor: Color = Color.White,
    isEnabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8
) {
    OutlinedButton(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(radios.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonTextColor
        )
    ) {
        Text(color = buttonTextColor, text = buttonText)
    }
}

@Preview
@Composable
fun OutlinedAppButtonPreview() {
    AppOutlinedButton(
        onClick = {}
    )
}

@Composable
fun AppOutlinedErrorButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Hello",
    buttonColor: Color = Colors.teal700,
    buttonTextColor: Color = Color.Red,
    onClick: (() -> Unit),
    isEnabled: Boolean = true,
    radios: Int = 8
) {
    OutlinedButton(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(radios.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonTextColor
        )
    ) {
        Text(color = buttonTextColor, text = buttonText)
    }
}

@Preview
@Composable
fun OutlinedAppErrorButtonPreview() {
    AppOutlinedErrorButton(
        onClick = {}
    )
}


@Composable
fun AppButtonWithTwoTextView(
    modifier: Modifier = Modifier,
    buttonText1: String = "AppButtonWithTwoTextView 1",
    buttonText2: String = "AppButtonWithTwoTextView 2",
    buttonColor: Color = Colors.teal700,
    buttonTextColor1: Color = Color.Red,
    buttonTextColor2: Color = Color.Green,
    space: Int = 10,
    isEnabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8
) {

    Button(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(radios.dp),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = buttonColor
        )
    ) {
        Text(color = buttonTextColor1, text = buttonText1)
        Spacer(Modifier.size(space.dp))
        Text(color = buttonTextColor2, text = buttonText2)
    }
}

@Preview
@Composable
fun AppButtonWithTwoTextViewPreview() {
    AppButtonWithTwoTextView(onClick = {})
}

@Composable
fun AppButtonWithElevation(
    modifier: Modifier = Modifier,
    buttonText: String = "Compose Button",
    buttonColor: Color = Colors.teal700,
    buttonTextColor: Color = Color.White,
    isEnabled: Boolean = true,
    onClick: (() -> Unit),
    radios: Int = 8,
    defaultElevation: Int = 0,
    pressedElevation: Int = 0,
    disabledElevation: Int = 0
) {
    AppButton(
        modifier = Modifier
            .padding(8.dp)
            .then(modifier),
        onClick = { onClick() },
        shape = RoundedCornerShape(radios.dp),
        isEnabled = isEnabled,
        buttonColor = buttonColor,
        buttonTextColor = buttonTextColor,
        buttonText = buttonText,
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        disabledElevation = disabledElevation
    )
}

@Preview
@Composable
fun AppButtonWithElevationPreview() {
    AppButtonWithElevation(buttonText = "App Button With Elevation", onClick = {})
}

@Composable
fun GradientAppButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Compose Button",
    onClick: (() -> Unit),
    gradient: Brush,
    textColor: Color = LocalContentColor.current,
    textModifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    shape: Shape = RoundedCornerShape(8.dp)
) {
    Button(
        modifier = modifier
            .padding(8.dp)
            .then(
                Modifier
                    .background(gradient, shape)
                    .padding(5.dp)
            ),
        onClick = { onClick() },
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        contentPadding = contentPadding,
    ) {
        Box(
            Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonText,
                modifier = textModifier,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun GradientAppButtonHorizontalPreview() {
    GradientAppButton(
        buttonText = "Gradient Button",
        onClick = {},
        gradient = Brush.horizontalGradient(
            listOf(
                Color(0xFF0F9D58),
                Color(0xFFA73A76)
            )
        ),
        textColor = Colors.white
    )
}

@Preview
@Composable
fun GradientAppButtonVerticalPreview() {
    GradientAppButton(
        buttonText = "Gradient Button",
        onClick = {},
        gradient = Brush.verticalGradient(
            listOf(
                Color(0xFF0F9D58),
                Color(0xFFA73A76)
            )
        ),
        textColor = Colors.white
    )
}


@Composable
fun CheckboxText(
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    checkboxModifier: Modifier = Modifier,
    enabled: Boolean = true,
    onCheckedChange: ((Boolean) -> Unit)
) {
    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = checkboxModifier,
            enabled = enabled
        )
        TextButton(
            modifier = modifier,
            onClick = { onCheckedChange(!checked) }
        ) {
            Text(text)
        }
    }
}

@Preview
@Composable
fun CheckboxTextPreview() {
    var checked = remember { mutableStateOf(false) }
    CheckboxText(
        text = "Checkbox Text",
        checked = checked.value,
        onCheckedChange = { checked.value = it }
    )
}

@Composable
fun LabeledSwitch(
    label: Pair<String, String>, // first: off, second: on
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
    switchState: MutableState<Boolean> = remember { mutableStateOf(false) },
    onChange: (Boolean) -> Unit
) {
    Row(modifier) {
        Switch(
            checked = switchState.value,
            onCheckedChange = { onChange(it); switchState.value = it }
        )
        Text(
            text = if (switchState.value) label.second else label.first,
            modifier = textModifier,
            color = textColor
        )
    }
}

@Preview
@Composable
fun LabeledSwitchPreview() {
    LabeledSwitch(label = Pair("Off", "On"), onChange = {})
}

// textTemplate is the all-in-one place to define text color, style and the rest.
//      Main reason is that modifiers don't really define the common attributes
//      of Text(), and it might not look neat for RadioButtons to copy all
//      the parameters of Text().
@Composable
fun RadioButtons(
    options: List<String>,
    currentOption: String, // This does a string match with the options
    modifier: Modifier = Modifier,
    textTemplate: @Composable (String) -> Unit = {
        Text(it, color = MaterialTheme.colorScheme.onSurface)
    },
    onSelect: (Int) -> Unit // This outputs the index chosen
) {
    @Composable
    fun RadioItem(
        option: Pair<Int, String>,
        isSelected: Boolean,
        textTemplate: @Composable (String) -> Unit,
        onSelect: (Int) -> Unit
    ) {
        Button(
            { onSelect(option.first) },
            shape = RectangleShape,
            colors = ButtonDefaults.textButtonColors()
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = isSelected, onClick = { onSelect(option.first) })
                textTemplate(option.second)
            }
        }
    }

    Column(
        Modifier
            .width(IntrinsicSize.Max)
            .background(MaterialTheme.colorScheme.surface)
            .then(modifier)
    ) {
        options.forEachIndexed { i, v ->
            RadioItem(
                Pair(i, v),
                currentOption == v,
                textTemplate,
                onSelect
            )
        }
    }
}

@Preview
@Composable
fun RadioButtonsPreview() {
    var currentOption = remember { mutableStateOf("Option 1") }
    RadioButtons(
        options = listOf("Option 1", "Option 2", "Option 3"),
        currentOption = currentOption.value,
        onSelect = { currentOption.value = "Option ${it + 1}" }
    )
}

@Composable
fun ProgressButton(
    text: String,
    loading: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = !loading,
        modifier = modifier
    ) {
        if (loading) {
            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 2.dp,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(text)
        }
    }
}

@Preview
@Composable
fun ProgressButtonPreview() {
    var loading = remember { mutableStateOf(false) }
    ProgressButton(
        text = "Submit",
        loading = loading.value,
        onClick = { loading.value = true }
    )
}


