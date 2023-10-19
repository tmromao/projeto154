package template.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import template.R


data class ProductItem(
    val name: String,
    val price: String,
    val imageRes: Int,
    val quantity: Int,
)

@Composable
fun ScreenCart(
    modifier: Modifier = Modifier,
    products: List<ProductItem> = emptyList(),
) {

    /*   BoxWithConstraints(modifier = modifier) {
           val rowsCount = 3
           val rowHeight = maxHeight / rowsCount
       }*/
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(products) { productItem ->
            cartItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
                    .background(Color.White)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                item = productItem,
            )
        }
    }

    Text("Preencher",
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}


@Composable
fun cartItem(
    modifier: Modifier,
    item: ProductItem,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(0.5f),
            //.background(Color.Red),
            painter = painterResource(id = item.imageRes),
            //contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier,

                ) {
                Text(
                    text = item.name,
                    //style = MaterialTheme.typography.h6,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = item.price,
                    //style = MaterialTheme.typography.body1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF4CAF50),
                )
            }
            Column(
                modifier = Modifier,

                ) {
                Text(
                    text = item.price,
                    //style = MaterialTheme.typography.h6,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = item.quantity.toString(),
                    //style = MaterialTheme.typography.body1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF4CAF50),
                )
            }
        }


    }
}


fun getProductsList(): List<ProductItem> {
    return listOf(
        ProductItem(
            name = "Headphones",
            price = "$ 99.99",
            imageRes = R.drawable.item_1,
            quantity = 1,
        ),
        ProductItem(
            name = "Smartwatch",
            price = "$ 99.99",
            imageRes = R.drawable.item_2,
            quantity = 1,
        ),
        ProductItem(
            name = "iPhone 12",
            price = "$ 99.99",
            imageRes = R.drawable.item_3,
            quantity = 1,
        ),
        ProductItem(
            name = "VisionX Pro LED TV",
            price = "$ 99.99",
            imageRes = R.drawable.item_4,
            quantity = 1,
        ),

        )
}

@Composable
@Preview(showBackground = true)
fun ScreenCartPreview() {
    ScreenCart(modifier = Modifier, getProductsList())
}

