package com.swasi.composeuikit


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.composeuikit.theme.Colors

@Composable
fun AppTextView(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Colors.teal700,
    fontSize: TextUnit = 16.sp,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text, fontSize = fontSize,
        fontFamily = fontFamily,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        style = style,
        color = color,
        modifier = Modifier
            .padding(0.dp)
            .then(
                modifier
            )
    )
}

@Composable
fun AppIconTextView(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    contentDescription: String? = null,
    iconTint: Color = Color.Unspecified,
    textColor: Color = Color.Unspecified,
    spacing: Dp = 8.dp,
    isIconAtStart: Boolean = true,
    fontSize: TextUnit = 16.sp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when {
            isIconAtStart -> {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    tint = iconTint
                )
                Spacer(modifier = Modifier.width(spacing))
                AppTextView(
                    text = text,
                    color = textColor,
                    fontSize = fontSize
                )
            }

            !isIconAtStart -> {
                AppTextView(
                    text = text,
                    color = textColor,
                    fontSize = fontSize
                )
                Spacer(modifier = Modifier.width(spacing))
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    tint = iconTint
                )
            }
        }
    }
}

@Preview
@Composable
fun ComposeIconTextViewPreview() {
    AppIconTextView(
        text = "Hello Compose Text View",
        modifier = Modifier.padding(16.dp),
        icon = ImageVector.vectorResource(R.drawable.ic_rabit),
        fontSize = 50.sp
    )
}

@Composable
fun TextWithSize(label: String, size: TextUnit) {
    Text(label, fontSize = size)
}

@Composable
fun ColorText() {
    Text("Color text", color = Color.Blue)
}

@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun MaxLines() {
    Text("hello ".repeat(50), maxLines = 2)
}

@Composable
fun OverflowedTextView() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Preview
@Composable
fun ComposeTextViewPreview() {
    Column {
        TextWithSize("Hello World", 30.sp)
        ColorText()
        BoldText()
        MaxLines()
        OverflowedTextView()
    }
}