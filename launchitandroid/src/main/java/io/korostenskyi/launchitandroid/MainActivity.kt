package io.korostenskyi.launchitandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.korostenskyi.launchitandroid.ui.theme.LaunchItTheme
import io.korostenskyi.shared.model.Post
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData()
        setContent {
            LaunchItTheme {
                MainScreenContent(viewModel)
            }
        }
    }
}

@Composable
fun PostCard(post: Post) {
    Card(
        elevation = 12.dp,
        modifier = Modifier.clickable {  }
    ) {
        Column {
            Text(
                text = post.title,
                fontWeight = FontWeight.Bold
            )
            Text(text = post.body)
        }
    }
}

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            PostCard(post)
        }
    }
}

@Composable
fun MainScreenContent(viewModel: MainViewModel) {
    val posts = viewModel.postFlow.collectAsState()
    PostList(posts.value)
}
